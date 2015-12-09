package com.hrd.app.article.configuration;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mangofactory.swagger.plugin.EnableSwagger;

@Configuration
@ComponentScan(basePackages="com.hrd.app.article")
@EnableWebMvc
@EnableSwagger
public class WebConfig extends WebMvcConfigurerAdapter {

	@Bean
	public ViewResolver getViewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/page/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	@Bean
    public MultipartResolver multipartResolver() {
        org.springframework.web.multipart.commons.CommonsMultipartResolver multipartResolver = new org.springframework.web.multipart.commons.CommonsMultipartResolver();
        //multipartResolver.setMaxUploadSize(2097152);
        multipartResolver.setMaxUploadSize(5242880);
        return multipartResolver;
    }
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry){
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	
	@Bean
	public DataSource getDataSource(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setUrl("jdbc:postgresql://localhost:5432/article");
		dataSource.setUsername("postgres");
		dataSource.setPassword("123");
		/*dataSource.setUrl("jdbc:postgresql://ec2-54-83-202-64.compute-1.amazonaws.com:5432/d4efr7mr9pennk?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory");
		dataSource.setUsername("exetnrzfonemai");
		dataSource.setPassword("Nm5Z7EvxTCV2s6LYzjR0-fucmq");*/
		return dataSource;
	}
	
}
