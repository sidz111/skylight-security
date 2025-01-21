package com.security.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails deepesh = User.withUsername("deepesh").password(passwordEncoder().encode("1234")).roles("USER").build();
		UserDetails akash = User.withUsername("akash").password(passwordEncoder().encode("1234")).roles("USER").build();
		UserDetails madhurani = User.withUsername("madhurani").password(passwordEncoder().encode("1234")).roles("USER").build();
		UserDetails siddhu = User.withUsername("siddhu").password(passwordEncoder().encode("1234")).roles("ADMIN").build();
		return new InMemoryUserDetailsManager(deepesh, akash, madhurani, siddhu);
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.csrf().disable()
		.authorizeHttpRequests()
		.requestMatchers("/deepesh")
		.hasRole("USER")
		.requestMatchers("/akash")
		.hasRole("USER")
		.requestMatchers("/madhurani")
		.hasRole("USER")
		.requestMatchers("/siddhu")
		.hasRole("ADMIN")
		.requestMatchers("/")
		.permitAll()
		.anyRequest()
		.authenticated()
		.and()
		.formLogin();
		return httpSecurity.build();
	}
}
