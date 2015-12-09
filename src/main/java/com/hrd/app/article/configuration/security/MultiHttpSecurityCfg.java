package com.hrd.app.article.configuration.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class MultiHttpSecurityCfg {
	
	@Autowired
	public void ConfigureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		auth.inMemoryAuthentication()
			.withUser("admin")
			.password("admin")
			.roles("ADMIN");
		auth.inMemoryAuthentication()
			.withUser("user")
			.password("user")
			.roles("USER");
		auth.inMemoryAuthentication()
			.withUser("SERCRET_API")
			.password("SERCRET_API")
			.roles("SERCRET_API");
	}
	@Configuration
	@Order(1)
	public static class ApiWebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter{
		protected void configure(HttpSecurity http) throws Exception{

			http.formLogin().loginPage("/login");
			http
				.antMatcher("/help")
				.authorizeRequests()
				.anyRequest()
				.hasRole("SERCRET_API")
				.and()
				.httpBasic()
				.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
			http.csrf().disable();		
		}
	}
	@Configuration
	public static class FormLoginWebSecurityConfigureAdapter extends WebSecurityConfigurerAdapter{
		protected void configure(HttpSecurity http) throws Exception {
			http.authorizeRequests()
				.antMatchers("/")
				.permitAll();
			
			
			
			http.authorizeRequests()
				.antMatchers("/user")
				.hasAnyRole("USER","ADMIN");
			
			http.authorizeRequests()
				.antMatchers("/admin")
				.hasAnyRole("ADMIN");
			http.formLogin();
			http.csrf().disable();
		}
	}
}
