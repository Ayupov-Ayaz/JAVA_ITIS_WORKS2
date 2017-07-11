package ru.itis.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * 11.07.2017
 * PersistenceConfig
 *
 * @author Ayupov Ayaz (First Software Engineering Platform)
 * @version v1.0
 */
@Configuration
@EnableJpaRepositories("ru.itis.dao")
@EnableTransactionManagement
//@PropertySource(value = "classpath:ru.itis\\spring\\db.properties")
public class PersistenceConfig {

    @Autowired
    private Environment environment;

    @Bean
    PlatformTransactionManager transactionManager(){
        return new JpaTransactionManager(entityManagerFactory().getObject());
    }

    @Bean
    LocalContainerEntityManagerFactoryBean entityManagerFactory(){
        LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();

        entityManager.setDataSource(dataSource());
        entityManager.setJpaVendorAdapter(hibernateJpaVendorAdapter());
        entityManager.setPackagesToScan("ru.itis.model");
        return entityManager;
    }

    @Bean
    DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/itis_users");
        dataSource.setUsername("postgres");
        dataSource.setPassword("aspirin12");
        dataSource.setDriverClassName("org.postgresql.Driver");
        return dataSource;
    }

    @Bean
    HibernateJpaVendorAdapter hibernateJpaVendorAdapter(){
        HibernateJpaVendorAdapter hibernateAdapter = new HibernateJpaVendorAdapter();
        hibernateAdapter.setShowSql(true);
        hibernateAdapter.setGenerateDdl(true);
        return hibernateAdapter;
    }
}
