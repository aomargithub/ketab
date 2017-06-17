package org.firstpartysystems.ketab.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = {"org.firstpartysystems.ketab.domain"})
@EnableTransactionManagement
public class PersistenceContext {

	@Bean
	@Profile("!test")
	public DataSource dataSource(Environment environment) {
		final JndiDataSourceLookup dsLookup = new JndiDataSourceLookup();
		dsLookup.setResourceRef(true);
		DataSource dataSource = dsLookup.getDataSource(environment.getRequiredProperty("app.datasource.lookupName"));
		return dataSource;
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(Environment environment, DataSource dataSource){
		
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setDataSource(dataSource);
		entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		
		entityManagerFactoryBean
				.setPersistenceUnitName(environment.getRequiredProperty("persistence.unit.ketab.name"));

		Properties jpaProperties = new Properties();

		jpaProperties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));

		jpaProperties.put("hibernate.hbm2ddl.auto", environment.getRequiredProperty("hibernate.hbm2ddl.auto"));

		jpaProperties.put("hibernate.ejb.naming_strategy",
				environment.getRequiredProperty("hibernate.ejb.naming_strategy"));

		jpaProperties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));

		jpaProperties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));

		jpaProperties.put("hibernate.jdbc.batch_size", environment.getRequiredProperty("hibernate.jdbc.batch_size"));

		jpaProperties.put("hibernate.transaction.jta.platform",
				environment.getRequiredProperty("hibernate.transaction.jta.platform"));

		entityManagerFactoryBean.setJpaProperties(jpaProperties);

		return entityManagerFactoryBean;	
	}
	
	
	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory){
		
		JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
		jpaTransactionManager.setEntityManagerFactory(entityManagerFactory);
		return jpaTransactionManager;		
	}
}
