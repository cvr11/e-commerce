/*
 * package com.ecommerce.controller;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.security.authentication.AuthenticationManager; import
 * org.springframework.security.authentication.BadCredentialsException; import
 * org.springframework.security.authentication.
 * UsernamePasswordAuthenticationToken; import
 * org.springframework.security.core.userdetails.UserDetails; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.RequestBody; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * import com.ecommerce.model.JwtRequest; import
 * com.ecommerce.model.JwtResponse; import com.orders.service.AuthUserService;
 * import com.orders.util.JwtUtility;
 * 
 * @RestController public class JWTAuthController {
 * 
 * @Autowired private JwtUtility jwtUtility;
 * 
 * @Autowired private AuthenticationManager authenticationManager;
 * 
 * @Autowired private AuthUserService userService;
 * 
 * @GetMapping(value = "/hello") public String home() { return
 * "welcome to Spring Security ..."; }
 * 
 * @PostMapping(value="auth") public JwtResponse autenticator(@RequestBody
 * JwtRequest jwtRequest) throws Exception { JwtResponse jwtResponse = new
 * JwtResponse(); try { authenticationManager.authenticate( new
 * UsernamePasswordAuthenticationToken( jwtRequest.getUsername(),
 * jwtRequest.getPassword()) ); } catch (BadCredentialsException e) { throw new
 * Exception ("Invalid_Credentials ...", e); } final UserDetails userDetails =
 * userService.loadUserByUsername(jwtRequest.getUsername()); final String token
 * = jwtUtility.generateToken(userDetails); jwtResponse.setJwttoken(token);
 * return jwtResponse; } }
 */