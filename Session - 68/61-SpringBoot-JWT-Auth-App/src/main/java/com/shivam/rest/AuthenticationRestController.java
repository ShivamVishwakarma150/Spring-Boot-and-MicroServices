package com.shivam.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shivam.security.AuthenticateRequest;
import com.shivam.security.JwtUtil;
import com.shivam.security.MyUserDetailsService;

@RestController
public class AuthenticationRestController {

	@Autowired
	private AuthenticationManager authManager;
	
	

	@Autowired
	private MyUserDetailsService userDetailsService;

	@Autowired
	private JwtUtil jwtUtil;

	@PostMapping("/authenticate")
	public String authenticate(@RequestBody AuthenticateRequest request) throws Exception {

		try {
			authManager.authenticate(
					new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

		} catch (Exception e) {
			throw new Exception("Invalid Username & Password");
		}

		UserDetails user = userDetailsService.loadUserByUsername(request.getUsername());
		
		

		// generate token based on user name
		String token = jwtUtil.generateToken(user);

		return token;

	}
}