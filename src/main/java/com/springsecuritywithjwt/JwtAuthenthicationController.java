package com.springsecuritywithjwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springsecuritywithjwt.pojo.AuthRequest;
import com.springsecuritywithjwt.service.JwtUtil;

@RestController
public class JwtAuthenthicationController {
	
	@Autowired
    private JwtUtil jwtUtil;
	
	  	@Autowired
	    private AuthenticationManager authenticationManager;
	
	
	@PostMapping("/authenticate")
	public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
		
		// in order to generate the token first we need to give username and password and this api will authenthicate username and password
		// once this detais are tested and if they are successfull then jwt token will be generated.
		
		
		//UsernamePasswordAuthenticationToken this hold the incoming request.
		try {
		 authenticationManager.authenticate(
                 new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
		} catch(Exception ex) {
			throw new Exception ("invalid user credentals");
			
		}
		
		return jwtUtil.generateToken(authRequest.getUsername());
		
	}

}
