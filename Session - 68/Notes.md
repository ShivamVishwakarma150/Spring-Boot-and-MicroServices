Here's the code snippet explaining each part of the `WebSecurityConfigurer` class:

```java
@Configuration
@EnableWebSecurity
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
```

In the above code:

- The `@Configuration` annotation indicates that this class is a configuration class.
- The `@EnableWebSecurity` annotation enables the Spring Security configuration for the application.

The class `WebSecurityConfigurer` extends `WebSecurityConfigurerAdapter`, which provides default security configurations that can be customized.

- The `@Autowired` annotation is used to inject the `MyUserDetailsService` bean into the `WebSecurityConfigurer` class. The `MyUserDetailsService` is responsible for loading user-specific data during authentication.

- The `configure(AuthenticationManagerBuilder auth)` method is overridden to configure the authentication mechanism. In this case, we set the `userDetailsService` using the `auth.userDetailsService(userDetailsService)` line. This means that the `MyUserDetailsService` will be used to load user-specific data during authentication.

- The `passwordEncoder()` method is annotated with `@Bean` and returns a `PasswordEncoder` instance. In this case, `NoOpPasswordEncoder.getInstance()` is used, which means no password encoding or hashing is applied to the user's password. This is not recommended for production use, as it poses a security risk. In a real-world application, you should use a strong password hashing algorithm, such as BCrypt, to store and compare passwords securely.

Please note that using `NoOpPasswordEncoder` is not secure, and it is recommended to use a proper password hashing mechanism like BCrypt or Argon2 for production applications to ensure the security of user passwords.

<br/>

The `MyUserDetailsService` class implements the `UserDetailsService` interface provided by Spring Security. It is responsible for loading user-specific data during the authentication process. Let's go through the code and understand each part:

```java
@Service
public class MyUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new User("admin", "admin@123", Collections.emptyList());
    }
}
```

- The `@Service` annotation indicates that this class is a service component and should be managed by the Spring framework.

- The `MyUserDetailsService` class implements the `UserDetailsService` interface, which requires implementing the `loadUserByUsername()` method. This method is called by Spring Security when attempting to authenticate a user.

- In the `loadUserByUsername()` method, a new instance of the `User` class is created and returned. The `User` class is provided by Spring Security and implements the `UserDetails` interface, representing a user in the system. It takes three arguments: the username, password, and a list of authorities (in this case, an empty list).

- In the code snippet, the method always returns the same hard-coded user information: username as "admin" and password as "admin@123". This is just an example for demonstration purposes. In a real-world scenario, you would typically fetch user information from a database or any other user repository based on the provided username.

- The `Collections.emptyList()` is used to provide an empty list of authorities (roles) for the user. In a more realistic scenario, you would load the user's roles and permissions based on the provided username and populate the `User` object accordingly.

To summarize, the `MyUserDetailsService` class provides the implementation for loading user-specific data during authentication. In this example, a hard-coded user with a username, password, and empty list of authorities is returned. In a real-world application, you would customize this class to retrieve user information from a data source, such as a database, and populate the `UserDetails` object accordingly.


<br/>

The `JwtUtil` class is responsible for handling JSON Web Tokens (JWTs) in Spring Boot. It provides methods to generate and validate JWTs. Let's go through the code and understand each part:

```java
package com.shivam.security;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtUtil {
	
	 private String SECRET_KEY = "secret";

	    public String extractUsername(String token) {
	        return extractClaim(token, Claims::getSubject);
	    }

	    public Date extractExpiration(String token) {
	        return extractClaim(token, Claims::getExpiration);
	    }

	    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
	        final Claims claims = extractAllClaims(token);
	        return claimsResolver.apply(claims);
	    }
	    private Claims extractAllClaims(String token) {
	        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
	    }

	    private Boolean isTokenExpired(String token) {
	        return extractExpiration(token).before(new Date());
	    }

	    public String generateToken(UserDetails userDetails) {
	        Map<String, Object> claims = new HashMap<>();
	        return createToken(claims, userDetails.getUsername());
	    }

	    private String createToken(Map<String, Object> claims, String subject) {

	        return Jwts.builder()
	        		   .setClaims(claims)
	        		   .setSubject(subject)
	        		   .setIssuedAt(new Date(System.currentTimeMillis()))
	        		   .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
	        		   .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
	        		   .compact();
	    }

	    public Boolean validateToken(String token, UserDetails userDetails) {
	        final String username = extractUsername(token);
	        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	    }

}
```

- The `JwtUtil` class contains various methods to handle JWTs.

- The `SECRET_KEY` variable represents the secret key used for signing and verifying the JWT. In this example, it is set to "secret". In a production environment, it is recommended to store the secret key securely and not hard-code it in the code.

- The `extractUsername()` method takes a JWT token as input and extracts the username from the token's claims (subject).

- The `extractExpiration()` method extracts the expiration date from the token's claims.

- The `extractClaim()` method is a generic method that takes a token and a `Function` as input. It extracts a specific claim from the token's claims using the provided `Function` as a resolver.

- The `extractAllClaims()` method parses the provided token and returns all the claims contained within it.

- The `isTokenExpired()` method checks if the provided token has expired by comparing the expiration date with the current date.

- The `generateToken()` method takes a `UserDetails` object (representing the authenticated user) and generates a JWT for that user. It creates a map of claims (empty in this example) and uses the `createToken()` method to build and sign the JWT.

- The `createToken()` method constructs the JWT using the provided claims, subject (username), issued date, expiration date, and signing algorithm. It signs the JWT using the secret key.

- The `validateToken()` method takes a token and a `UserDetails` object and validates if the token is valid. It checks if the username extracted from the token matches the username of the `UserDetails

` object and verifies that the token has not expired.

To summarize, the `JwtUtil` class provides utility methods to work with JWTs in Spring Boot. It allows extracting claims from a token, checking if a token has expired, generating a JWT for a user, and validating the token against user details. This class is an essential component when implementing JWT-based authentication and authorization in a Spring Security application.

<br/>

The `AuthenticateRequest` class and the `AuthenticationResource` class are part of the code implementation for handling user authentication. Let's go through each of them in detail:

1. `AuthenticateRequest` class:
```java
@Data
public class AuthenticateRequest {
    private String username;
    private String password;
}
```
The `AuthenticateRequest` class is a simple data class (POJO) that is used to capture the username and password for authentication purposes. It has two fields, `username` and `password`, along with their getter and setter methods. This class is used to receive the authentication request from the client.

1. `AuthenticationResource` class:
```java
package com.shivam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.shivam.security.AuthenticateRequest;
import in.shivam.security.JwtUtil;
import in.shivam.security.MyUserDetailsService;

@RestController
public class AuthenticationResource {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/authenticate")
    public String authenticate(@RequestBody AuthenticateRequest request) throws Exception {
        try {
            authManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        } catch (Exception e) {
            throw new Exception("Invalid Username & Password");
        }

        UserDetails user = userDetailsService.loadUserByUsername(request.getUsername());
        String token = jwtUtil.generateToken(user);

        return token;
    }
}
```
The `AuthenticationResource` class is a REST controller responsible for handling authentication requests. Let's examine the different parts of the class:

- It is annotated with `@RestController` to indicate that this class handles HTTP requests and returns the response directly.

- The `AuthenticationManager` is autowired to authenticate the user credentials. It is responsible for validating the username and password provided in the `AuthenticateRequest`.

- The `MyUserDetailsService` and `JwtUtil` components are autowired for retrieving user details and generating JWTs, respectively.

- The `@PostMapping("/authenticate")` annotation specifies that this method handles POST requests to the "/authenticate" endpoint.

- The `authenticate()` method takes the `AuthenticateRequest` object as a request body. It attempts to authenticate the user's credentials using the `AuthenticationManager` by creating an `UsernamePasswordAuthenticationToken` with the provided username and password.

- If the authentication is successful, the `loadUserByUsername()` method of `MyUserDetailsService` is called to retrieve the user details. The returned `UserDetails` object is used to generate a JWT token using the `JwtUtil` component.

- Finally, the generated JWT token is returned as the response.

To summarize, the `AuthenticationResource` class handles the authentication request by receiving the username and password in the `AuthenticateRequest` object. It authenticates the user credentials using the `AuthenticationManager`, retrieves the user details using the `MyUserDetailsService`, generates a JWT token using the `JwtUtil`, and returns the token as the response.

<br/>

In the `SecurityConfigurer` class, we configure the authentication manager bean and define the permissions for different endpoints. Let's go through the code in detail:

```java
@Override
@Bean
public AuthenticationManager authenticationManagerBean() throws Exception {
    return super.authenticationManagerBean();
}
```
This method overrides the `authenticationManagerBean()` method from `WebSecurityConfigurerAdapter` and exposes the `AuthenticationManager` bean as a Spring bean. It is required to authenticate the user credentials in the `AuthenticationResource` class.

```java
@Override
protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable()
        .authorizeRequests()
        .antMatchers("/authenticate")
        .permitAll()
        .anyRequest()
        .authenticated();
}
```
The `configure(HttpSecurity http)` method is also overridden from `WebSecurityConfigurerAdapter` to configure the security settings. Let's break it down:

- `http.csrf().disable()` disables CSRF (Cross-Site Request Forgery) protection. Since we are using JWT for authentication, we don't need CSRF protection.

- `.authorizeRequests()` indicates that we are configuring authorization rules for different endpoints.

- `.antMatchers("/authenticate").permitAll()` specifies that the "/authenticate" endpoint should be accessible to all users without authentication. This endpoint is used for user authentication.

- `.anyRequest().authenticated()` ensures that any other request that is not matched by previous rules requires authentication. In other words, all other endpoints require the user to be authenticated.

To summarize, the `configure(HttpSecurity http)` method configures the security rules. It disables CSRF protection, permits access to the "/authenticate" endpoint without authentication, and requires authentication for all other endpoints.

By overriding the `authenticationManagerBean()` method, we expose the `AuthenticationManager` bean, which is used by the `AuthenticationResource` class to authenticate the user credentials. The `configure(HttpSecurity http)` method defines the security rules, allowing or denying access to different endpoints based on their configurations.

<br/>

The `JwtRequestFilter` class is responsible for intercepting each incoming request and processing the JWT token for authentication. Let's go through the code in detail:

```java
@Component
public class JwtRequestFilter extends OncePerRequestFilter {
    // ...
}
```
The `JwtRequestFilter` is annotated with `@Component` to indicate that it is a Spring component and should be automatically detected and instantiated by the Spring container. It extends the `OncePerRequestFilter` class, which ensures that the filter is only applied once per request.

```java
@Autowired
private MyUserDetailsService userDetailsService;

@Autowired
private JwtUtil jwtUtil;
```
The `JwtRequestFilter` class autowires the `MyUserDetailsService` and `JwtUtil` beans, which are used for user details retrieval and JWT processing, respectively. These dependencies are injected by the Spring container.

```java
@Override
protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
        throws ServletException, IOException {
    // ...
}
```
The `doFilterInternal` method is overridden from the `OncePerRequestFilter` class and contains the logic for filtering and processing each request.

```java
String authorizationHeader = request.getHeader("Authorization");
String username = null;
String jwt = null;

if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
    jwt = authorizationHeader.substring(7);
    username = jwtUtil.extractUsername(jwt);
}
```
In this section, the filter retrieves the JWT token from the request's "Authorization" header. If the header is present and starts with "Bearer ", it extracts the JWT token and the corresponding username.

```java
if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
    UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
    if (jwtUtil.validateToken(jwt, userDetails)) {
        // ...
    }
}
```
If a valid username is extracted from the token and no authentication has been set in the security context, the filter proceeds to validate the token using the `JwtUtil` class. If the token is valid, it retrieves the user details for the corresponding username using the `MyUserDetailsService` class.

```java
UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
    userDetails, null, userDetails.getAuthorities());
usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
```
If the token is valid, a new `UsernamePasswordAuthenticationToken` is created with the user details and authorities. The authentication token is then set in the security context using `SecurityContextHolder.getContext().setAuthentication()`.

```java
filterChain.doFilter(request, response);
```
Finally, the filter chain is invoked to allow the request to continue its processing.

To summarize, the `JwtRequestFilter` intercepts each incoming request and extracts the JWT token from the "Authorization" header. It validates the token, retrieves the user details, and sets the authentication token in the security context if the token is valid. This filter ensures that requests are authenticated using the provided JWT token.

<br/>

Certainly! Let's go through the `configure(HttpSecurity http)` method in detail:

```java
@Override
protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable()
        .authorizeRequests()
        .antMatchers("/authenticate").permitAll()
        .anyRequest().authenticated()
        .and()
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

    http.addFilterBefore(jwtReqFilter, UsernamePasswordAuthenticationFilter.class);
}
```

Explanation:
- `http.csrf().disable()` disables Cross-Site Request Forgery (CSRF) protection. In this example, we are omitting CSRF protection for simplicity. However, in a production environment, it is recommended to enable CSRF protection to prevent unauthorized requests.
- `authorizeRequests()` indicates that we are configuring authorization rules for our application.
- `antMatchers("/authenticate").permitAll()` specifies that the `/authenticate` endpoint should be accessible without authentication. This endpoint is responsible for user authentication and token generation.
- `anyRequest().authenticated()` configures that any other request requires authentication. This means that all endpoints other than `/authenticate` need a valid JWT token for access.
- `sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)` indicates that our application does not create or use session state. Since we are using JWT tokens, we can set the session creation policy to `STATELESS` to eliminate the need for sessions.
- `http.addFilterBefore(jwtReqFilter, UsernamePasswordAuthenticationFilter.class)` adds the `JwtRequestFilter` before the `UsernamePasswordAuthenticationFilter` in the filter chain. This ensures that the JWT token is processed and authenticated before the default form-based authentication mechanism.

By configuring the `HttpSecurity` object in this way, we define the security rules for our application. We allow unauthenticated access to the `/authenticate` endpoint for user authentication, and all other requests require a valid JWT token for authentication.

The `JwtRequestFilter` is then applied to intercept each request and validate the JWT token. If the token is valid, the user is authenticated, and if not, the request is denied.

This configuration ensures that only authenticated users with valid JWT tokens can access the protected resources of our application.

