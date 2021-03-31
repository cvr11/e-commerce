/*
 * package com.ecommerce.config;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.security.authentication.AuthenticationManager; import
 * org.springframework.security.config.annotation.authentication.builders.
 * AuthenticationManagerBuilder; import
 * org.springframework.security.config.annotation.web.builders.HttpSecurity;
 * import org.springframework.security.config.annotation.web.configuration.
 * EnableWebSecurity; import
 * org.springframework.security.config.annotation.web.configuration.
 * WebSecurityConfigurerAdapter; import
 * org.springframework.security.config.http.SessionCreationPolicy; import
 * org.springframework.security.crypto.password.NoOpPasswordEncoder; import
 * org.springframework.security.crypto.password.PasswordEncoder; import
 * org.springframework.security.web.authentication.
 * UsernamePasswordAuthenticationFilter;
 * 
 * import com.orders.service.AuthUserService; import com.orders.util.JwtFilter;
 * 
 * @Configuration
 * 
 * @EnableWebSecurity public class SpringSecurityConfig extends
 * WebSecurityConfigurerAdapter {
 * 
 * @Autowired private AuthUserService userService;
 * 
 * @Autowired JwtFilter jwtFilter;
 * 
 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
 * Exception{ auth.userDetailsService(userService); }
 * 
 * @Override protected void configure(HttpSecurity http) throws Exception{
 * http.csrf() .disable() .authorizeRequests() .antMatchers("/auth")
 * .permitAll().anyRequest().authenticated().and().sessionManagement().
 * sessionCreationPolicy(SessionCreationPolicy.STATELESS);
 * http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
 * }
 * 
 * @Override
 * 
 * @Bean public AuthenticationManager authenticationManagerBean() throws
 * Exception { return super.authenticationManagerBean(); }
 * 
 * // Below is used for static/Hardcoded Users // Authentication : User ==>
 * Roles protected void configure(AuthenticationManagerBuilder auth) throws
 * Exception{
 * auth.inMemoryAuthentication().withUser("USER1").password("secret123").roles(
 * "USER").and()
 * .withUser("ADMIN1").password("secret123").roles("USER","ADMIN");
 * //auth.inMemoryAuthentication().withUser("ADMIN1").password("secret123").
 * roles("USER","ADMIN"); }
 * 
 * // Authentication : Role ==> Access protected void configure(HttpSecurity
 * http) throws Exception{
 * http.httpBasic().and().authorizeRequests().antMatchers("/getorder",
 * "/processOrder").hasRole("USER") .antMatchers("/**").hasRole("ADMIN")
 * .and().csrf().disable().headers().frameOptions().disable(); }
 * 
 * 
 * 
 * @Bean public PasswordEncoder passwordEncoder() { return
 * NoOpPasswordEncoder.getInstance(); }
 * 
 * }
 */