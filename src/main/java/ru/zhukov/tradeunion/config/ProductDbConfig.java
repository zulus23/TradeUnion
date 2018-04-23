package ru.zhukov.tradeunion.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
@EnableConfigurationProperties
public class ProductDbConfig {

    @Autowired
    private Environment env;

    @Bean
    @ConfigurationProperties(prefix="datasource.product")
    public DataSourceProperties productDataSourceProperties()
    {

        DataSourceProperties dataSourceProperties = new DataSourceProperties();
        if(System.getenv("COMPUTERNAME").toUpperCase().equals("desktop-GBBOAS1".toUpperCase())){
            dataSourceProperties.setUrl("jdbc:sqlserver://desktop-GBBOAS1;databaseName=ait_all;applicationName=TradeUnion");
        }
        return dataSourceProperties;
    }
}
