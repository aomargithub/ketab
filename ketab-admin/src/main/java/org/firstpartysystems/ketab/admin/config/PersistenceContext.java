package org.firstpartysystems.ketab.admin.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;

@Configuration
public class PersistenceContext {

	@Bean
	@Profile("!test")
	public DataSource dataSource(Environment environment) {
		final JndiDataSourceLookup dsLookup = new JndiDataSourceLookup();
		dsLookup.setResourceRef(true);
		DataSource dataSource = dsLookup.getDataSource(environment.getRequiredProperty("app.datasource.lookupName"));
		return dataSource;
	}
}
