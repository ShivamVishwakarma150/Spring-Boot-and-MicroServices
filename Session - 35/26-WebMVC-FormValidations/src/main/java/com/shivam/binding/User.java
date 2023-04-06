package com.shivam.binding;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class User {
	
	@NotEmpty(message="uname is required")
	@Size(min=3,max=8,message="Username should be between 3 to 8 character")
	private String uname;
	
	@NotEmpty(message="password is required")
	private String pwd;
	
	@NotEmpty(message="email is required")
	@Email(message="Enter valid email id")
	private String email;
	
	
	@NotEmpty(message="phone no is required")
	@Size(min=10,message="Phone no atleast 10 digits")
	private String phno;
	
	@NotNull(message="Age is required")
	private Integer age;
	
}
