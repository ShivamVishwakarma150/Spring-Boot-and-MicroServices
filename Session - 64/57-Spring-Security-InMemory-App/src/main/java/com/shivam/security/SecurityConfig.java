package com.shivam.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	/**
	 * In this method we will configure Authentication credentials
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		// {noop} --> No Operation for password encoder

		auth.inMemoryAuthentication().withUser("devs").password("{noop}devs").authorities("ADMIN");
		auth.inMemoryAuthentication().withUser("ns").password("{noop}devs").authorities("EMPLOYEE");
		auth.inMemoryAuthentication().withUser("vs").password("{noop}devs").authorities("MANAGER");

	}

	/**
	 * In this method we will configure Authorization roles
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
			http.authorizeRequests()
				.antMatchers("/home").permitAll()
				.antMatchers("/welcome").authenticated()
				.antMatchers("/admin").hasAuthority("ADMIN")
				.antMatchers("/emp").hasAuthority("EMPLOYEE")
				.antMatchers("/mgr").hasAuthority("MANAGER")
				.antMatchers("/common").hasAnyAuthority("EMPLOYEE", "MANAGER")
				
				.anyRequest().authenticated()
				
				.and()
				.formLogin()
				.defaultSuccessUrl("/welcome",true)
				
				.and()
				.logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				
				.and()
				.exceptionHandling()
				.accessDeniedPage("/accessDenied");
		
	}

}
