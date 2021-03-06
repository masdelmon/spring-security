package com.journaldev.webapp.spring.security;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.journaldev.webapp.spring.dao.AppUserDetailsServiceDAO;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	public void configure(AuthenticationManagerBuilder auth)
			throws Exception {

		// in-memory authentication
		auth.inMemoryAuthentication().withUser("masdelmon").password("masdelmon").roles("USER");

		// using custom UserDetailsService DAO
		auth.userDetailsService(new AppUserDetailsServiceDAO());

		// using JDBC
		
		
		
		
		
		
	}
	
	@Override
    public void configure(WebSecurity web) throws Exception {
        web
            .ignoring()
                // Spring Security should completely ignore URLs starting with /resources/
                .antMatchers("/*.html");
    }

}
