//package com.springboot.automation.config;
//
//import com.zaxxer.hikari.HikariDataSource;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import javax.sql.DataSource;
//import java.util.Objects;
//
//@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories(
//        basePackages = "com.springboot.automation.repository.oracle",
//        entityManagerFactoryRef = "oracleEntityManagerFactory",
//        transactionManagerRef = "oracleTransactionManager"
//)
//public class OracleDatabaseConfig {
//    @Bean
//    @ConfigurationProperties("spring.datasource.oracle")
//    public DataSourceProperties oracleDataSourceProperties(){
//        return new DataSourceProperties();
//    }
//
//    @Bean
//    @ConfigurationProperties("spring.datasource.oracle.configuration")
//    public DataSource oracleDataSource(){
//        return oracleDataSourceProperties().initializeDataSourceBuilder().type(HikariDataSource.class).build();
//    }
//
//    @Bean(name = "oracleEntityManagerFactory")
//    public LocalContainerEntityManagerFactoryBean oracleEntityManagerFactory(EntityManagerFactoryBuilder builder){
//        return builder.dataSource(oracleDataSource()).packages("com.springboot.automation.entity.oracle").build();
//    }
//
//    @Bean(name = "oracleTransactionManager")
//    public PlatformTransactionManager oracleTransactionManager(final @Qualifier("oracleEntityManagerFactory")
//                                                              LocalContainerEntityManagerFactoryBean oracleEntityManagerFactory){
//        return new JpaTransactionManager(Objects.requireNonNull(oracleEntityManagerFactory.getObject()));
//    }
//}
