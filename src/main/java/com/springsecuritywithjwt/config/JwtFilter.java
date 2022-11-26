package com.springsecuritywithjwt.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.springsecuritywithjwt.service.JwtUtil;
import com.springsecuritywithjwt.service.VehicleUserDetailsService;


@Component
public class JwtFilter extends OncePerRequestFilter{

	 @Autowired
	    private JwtUtil jwtUtil;
	
	 @Autowired
	 private VehicleUserDetailsService service;
	
	// this method used to take token from header which have authorization field 
	//it extract token an validate the token once validation is done and its successfull it will process the actua; vehicle controller
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String authorizationHeader = request.getHeader("Authorization");

        String token = null;
        String userName = null;

        // it ll check if authorizationHeader is not null and starts with bearer it will extract username 
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            token = authorizationHeader.substring(7);
            userName = jwtUtil.extractUsername(token);
        }
        
        if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {

            UserDetails userDetails = service.loadUserByUsername(userName);

            if (jwtUtil.validateToken(token, userDetails)) {

                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                usernamePasswordAuthenticationToken
                        .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }
        filterChain.doFilter(request, response);
        
		
	}

}
