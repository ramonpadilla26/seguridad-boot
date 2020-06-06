package com.uabd.edu.mx.seguridad.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	UserDetailsService userDetailsService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		http //AUTORIZAR PETICIONES
//			.authorizeRequests()
//				//HAGA MATCH / /home
//				.antMatchers("/", "/index","/*.jpg","/*.js","/*.css").permitAll()
//				.anyRequest().authenticated()
//				.and()
//			.formLogin()
//				.loginPage("/login")
//				.permitAll()
//				.and()
//
//				.logout()
//				.permitAll();


		http.authorizeRequests().
				antMatchers("/admin").hasRole("ADMIN").
				antMatchers("/user").hasAnyRole("ADMIN","USER").
				antMatchers("/").permitAll().and().formLogin();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}


	@Bean
	public PasswordEncoder getPasswordEncoder(){

		return NoOpPasswordEncoder.getInstance();
	}

//	@Bean
//	@Override
//	public UserDetailsService userDetailsService() {
//		UserDetails user =
//				User.withDefaultPasswordEncoder()
//						.username("user")
//						.password("password")
//						.roles("USER")
//						.build();
//
//		return new InMemoryUserDetailsManager(user);
//	}
}
