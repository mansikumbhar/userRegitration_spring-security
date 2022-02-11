package com.userRegistration.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled=true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	

	
	@Bean
	public UserDetailsService userDetailsService () {
		return new UserDetailsServiceImpl();
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new  BCryptPasswordEncoder();
	}
	
	
	//bean for authentication provider
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider=new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());
		return authProvider;
	}
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.authenticationProvider(authenticationProvider());
		
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		
		
		
		http
		
		.authorizeRequests()
		.antMatchers("/", "/index").permitAll()
		.antMatchers("/updateRegistration").hasAnyAuthority("ADMIN","User")
		.antMatchers("/deleteRegistration").hasAuthority("ADMIN")
		.and().formLogin()
		
		//.defaultSuccessUrl("/WEB-INF/jsp/index",true)
		.permitAll()
		.and().logout()
		.and()
		.exceptionHandling().accessDeniedPage("/403");
		
		
		http.csrf().disable() ;
		
	}
	
	
}
