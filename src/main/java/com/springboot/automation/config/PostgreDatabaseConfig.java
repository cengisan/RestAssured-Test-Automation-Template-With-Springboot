//package com.springboot.automation.config;
//
//import com.zaxxer.hikari.HikariDataSource;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
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
//        basePackages = "com.springboot.automation.repository.postgre",
//        entityManagerFactoryRef = "postgreEntityManagerFactory",
//        transactionManagerRef = "postgreTransactionManager"
//)
//
//public class PostgreDatabaseConfig {
//
//    @Bean
//    @Primary
//    @ConfigurationProperties("spring.datasource.postgre")
//    public DataSourceProperties postgreDataSourceProperties(){
//        return new DataSourceProperties();
//    }
//
//    @Bean
//    @Primary
//    @ConfigurationProperties("spring.datasource.postgre.configuration")
//    public DataSource postgreDataSource(){
//        return postgreDataSourceProperties().initializeDataSourceBuilder().type(HikariDataSource.class).build();
//    }
//
//    @Bean(name = "postgreEntityManagerFactory")
//    @Primary
//    public LocalContainerEntityManagerFactoryBean postgreEntityManagerFactory(EntityManagerFactoryBuilder builder){
//        return builder.dataSource(postgreDataSource()).packages("com.springboot.automation.entity.postgre").build();
//    }
//
//    @Bean(name = "postgreTransactionManager")
//    @Primary
//    public PlatformTransactionManager postgreTransactionManager(final @Qualifier("postgreEntityManagerFactory")
//                                                                  LocalContainerEntityManagerFactoryBean postgreEntityManagerFactory){
//        return new JpaTransactionManager(Objects.requireNonNull(postgreEntityManagerFactory.getObject()));
//    }
//}
