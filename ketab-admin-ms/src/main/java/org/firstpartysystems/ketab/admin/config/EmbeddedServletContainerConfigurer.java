package org.firstpartysystems.ketab.admin.config;

import javax.sql.DataSource;

import org.apache.catalina.startup.Tomcat;
import org.apache.tomcat.util.descriptor.web.ContextResource;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class EmbeddedServletContainerConfigurer {
	
	
	@Bean
	public TomcatEmbeddedServletContainerFactory tomcatFactory() {
	    return new TomcatEmbeddedServletContainerFactory() {

	        @Override
	        protected TomcatEmbeddedServletContainer getTomcatEmbeddedServletContainer(
	                Tomcat tomcat) {
	            tomcat.enableNaming();
	            return super.getTomcatEmbeddedServletContainer(tomcat);
	        }
	    };
	}
	
	
	@Bean 
	EmbeddedServletContainerCustomizer containerCustomizer(Environment environment){
		return (container) -> {
			TomcatEmbeddedServletContainerFactory tomcatFactory = (TomcatEmbeddedServletContainerFactory)container;
			
			tomcatFactory.addContextCustomizers((context) -> {
				ContextResource contextResource = new ContextResource();
				contextResource.setName(environment.getRequiredProperty("app.datasource.bindName"));
				contextResource.setType(DataSource.class.getName());
				contextResource.setProperty("driverClassName", environment.getRequiredProperty("app.datasource.driverClassName"));
				contextResource.setProperty("url", environment.getRequiredProperty("app.datasource.url"));
				contextResource.setProperty("username", environment.getRequiredProperty("app.datasource.username"));
				contextResource.setProperty("password", environment.getRequiredProperty("app.datasource.password"));
				
				context.getNamingResources().addResource(contextResource);
			});
		};
	}
}
