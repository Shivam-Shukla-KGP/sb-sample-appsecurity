package in.jp.trial.sb.sample.security.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.TransactionManager;


import javax.sql.DataSource;

@Configuration
@ComponentScan("in.jp.trial.sb.sample.security")
public class SecurityConfiguration {

    @Autowired
    SecurityDatasourceConfig securityDatasourceConfig;

//    @Bean(name="dataSource")
//    DataSource createDataSource() {
//        HikariConfig config = new HikariConfig();
////        System.out.println(securityDatasourceConfig.getUrl());
////        System.out.println(securityDatasourceConfig.getUsername());
////        System.out.println(securityDatasourceConfig.getPassword());
////        System.out.println(securityDatasourceConfig.getDriverClassName());
//        config.setUsername(securityDatasourceConfig.getUsername());
//        config.setPassword(securityDatasourceConfig.getPassword());
//        config.setDriverClassName(securityDatasourceConfig.getDriverClassName());
//        config.setJdbcUrl(securityDatasourceConfig.getUrl());
////        config.setDriverClassName(securityDatasourceConfig.getDriverClassName());
//        config.setAutoCommit(true);
//        DataSource dataSource = new HikariDataSource(config);
//
//        return dataSource;
//    }

    @Bean(name="dataSource")
    DataSource createDataSource() {
        HikariConfig config = new HikariConfig();
        config.setUsername(securityDatasourceConfig.getUsername());
        config.setPassword(securityDatasourceConfig.getPassword());
        config.setDriverClassName(securityDatasourceConfig.getDriverClassName());
        config.setJdbcUrl(securityDatasourceConfig.getUrl());
        config.setAutoCommit(true);
//        EmbeddedDatabase dataSource = new EmbeddedDatabaseBuilder()
//                .setType(EmbeddedDatabaseType.H2)
//                .build();
        DataSource dataSource = new HikariDataSource(config);

        return dataSource;
    }

    @Bean(name="transactionManager")
    TransactionManager createTransactionManager(DataSource dataSource){
        TransactionManager transactionManager = new JpaTransactionManager();

        //JDBC TransactionManager and DataSourceTransactionManager are not feasible to use with JPA Repositories.
        //TransactionManager transactionManager = new JdbcTransactionManager(dataSource);
        //transactionManager.setDataSource(dataSource);
        //transactionManager.afterPropertiesSet();
        return transactionManager;
    }

}
