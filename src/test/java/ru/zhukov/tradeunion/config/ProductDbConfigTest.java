package ru.zhukov.tradeunion.config;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Primary;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import ru.zhukov.tradeunion.TradeunionApplication;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ProductDbConfig.class)
@TestPropertySource(
        locations = "classpath:application.properties")

/*@EnableConfigurationProperties()*/
public class ProductDbConfigTest {

    @Autowired
    DataSourceProperties dataSourceProperties;

    @Test
    public void getNameLocalComputer(){
        //System.getenv().forEach((k,v)->System.out.println(k+" -- " +v));
        assertEquals("desktop-GBBOAS1".toUpperCase(),System.getenv("COMPUTERNAME").toUpperCase());

    }
    @Test
    public void urlForDBMustBeSetRight(){
        if (System.getenv("COMPUTERNAME").toUpperCase().equals("desktop-GBBOAS1".toUpperCase())){
            assertEquals("jdbc:sqlserver://desktop-GBBOAS1;databaseName=ait_all;applicationName=TradeUnion",
                          dataSourceProperties.getUrl());

        }else {
            assertEquals("jdbc:sqlserver://SRV-SQLBOX;instanceName=AIT;databaseName=ait_all;applicationName=TradeUnion",
                    dataSourceProperties.getUrl());
        }

        assertEquals("report",dataSourceProperties.getUsername());
    }

    @Test
    public void productDataSourceProperties() {
    }
}
