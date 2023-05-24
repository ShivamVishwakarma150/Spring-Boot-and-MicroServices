package com.shivam.security;

import lombok.Data;

@Data
public class AuthenticateRequest {
	private String username;
	private String password;
}
