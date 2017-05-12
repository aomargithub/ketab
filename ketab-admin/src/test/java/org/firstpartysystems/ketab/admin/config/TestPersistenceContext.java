package org.firstpartysystems.ketab.admin.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Configuration
@Profile("test")
public class TestPersistenceContext {

	@Bean
	public DataSource dataSource() {
		return new EmbeddedDatabaseBuilder().setName("jdbc:h2:mem:testdb;MODE=MYSQL").setType(EmbeddedDatabaseType.H2)
				.addScripts("db-schema.sql", "db-test-data.sql").build();
	}
}
