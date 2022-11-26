package com.springsecuritywithjwt.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.springsecuritywithjwt.service.JwtUtil;
import com.springsecuritywithjwt.service.VehicleUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig  extends WebSecurityConfigurerAdapter{
	
	
	@Autowired
	private VehicleUserDetailsService vehicleUserDetailsService;
	
	@Autowired
	private JwtFilter jwtFilter;
	
	
	@Override 
	protected void configure (AuthenticationManagerBuilder auth) throws Exception {
		//auth.userDetailsService(employeeInfoUserDetailsService).passwordEncoder(passwordEncoder());
		   auth.inMemoryAuthentication().withUser("sindhu")
		   .password(passwordEncoder().encode("secret")).roles("ADMIN");
		   auth.inMemoryAuthentication().withUser("sindhuja").password(passwordEncoder().encode("jwtsecret1")).roles("ADMIN");
          // .withUser("sindhu").password(passwordEncoder.encode("secret"))
           //.roles("USER");
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
	 @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http.csrf().disable();
        	//http.antMatcher("/**").permitAll();
        	//authorizeRequests().and().antMatcher("/login").permitAll();

	        http.antMatcher("/secure").authorizeRequests().antMatchers("/authenthicate").permitAll();
	        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);                
	        		//.sessionCreationPolicy(SessionCreationPolicy.STATELESS);)
	                //exceptionHandling().and().sessionManagement()
	                //.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
	    }
	 
	
}
