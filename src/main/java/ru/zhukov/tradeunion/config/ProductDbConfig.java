package ru.zhukov.tradeunion.config;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration

@EnableJpaRepositories(
        basePackages = "ru.zhukov.tradeunion",
        entityManagerFactoryRef = "productEntityManagerFactory",
        transactionManagerRef = "productTransactionManager"
)
@EnableConfigurationProperties
public class ProductDbConfig {

    @Autowired
    private Environment env;

    @Bean
    @ConfigurationProperties(prefix="datasource.home")
    public DataSourceProperties productDataSourceProperties()
    {

        DataSourceProperties dataSourceProperties = new DataSourceProperties();
        if(System.getenv("COMPUTERNAME").toUpperCase().equals("desktop-GBBOAS1".toUpperCase())){
            dataSourceProperties.setUrl("jdbc:sqlserver://desktop-GBBOAS1;databaseName=ait_all;applicationName=TradeUnion");
        }
        return dataSourceProperties;
    }

    @Bean
    public DataSource productDataSource(){
        DataSourceProperties sourceProperties = productDataSourceProperties();
        return DataSourceBuilder.create()
                         .driverClassName(sourceProperties.getDriverClassName())
                         .url(sourceProperties.getUrl())
                         .username(sourceProperties.getUsername())
                         .password(sourceProperties.getPassword())
                         .build();
    }

    @Bean
    public PlatformTransactionManager productTransactionManager(){
        EntityManagerFactory factory = productEntityManagerFactory().getObject();
        return  new JpaTransactionManager(factory);
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean productEntityManagerFactory() {
        LocalContainerEntityManagerFactoryBean factoryBean =
                              new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(productDataSource());
        factoryBean.setPackagesToScan("ru.zhukov.tradeunion");
        factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        Properties jpaProperties = new Properties();
       // jpaProperties.put("hibernate.show-sql", env.getProperty("hibernate.show-sql"));
        jpaProperties.put("hibernate.show-sql", true);
        factoryBean.setJpaProperties(jpaProperties);

        return factoryBean;
    }

}
