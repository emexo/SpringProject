/*
 package com.bankingmanagement;
 
 import org.springframework.context.annotation.Bean;
 import org.springframework.context.annotation.Configuration;
 import org.springframework.context.annotation.Profile;
 import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
 import org.springframework.security.config.annotation.web.builders.HttpSecurity;
 import org.springframework.security.core.userdetails.User;
 import org.springframework.security.core.userdetails.UserDetails;
 import org.springframework.security.provisioning.InMemoryUserDetailsManager;
 import org.springframework.security.web.SecurityFilterChain;
 
 @Profile("prod")
 @Configuration
 @EnableGlobalMethodSecurity(prePostEnabled = true)
 public class SecurityConfig
 {
     @Bean
     public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
 
         http.csrf().disable()
                 .authorizeRequests()
                 .antMatchers("/api/v1/banks").permitAll()
                 .anyRequest().authenticated()
                 .and()
                 .httpBasic();
 
         return http.build();
     }
 
     @Bean
     public InMemoryUserDetailsManager userDetailsService() {
         UserDetails user = User
                 .withUsername("user")
                 .password("{noop}password")
                 .roles("USER")
                 .build();
         UserDetails admin = User
                 .withUsername("admin")
                 .password("{noop}password")
                 .roles("ADMIN")
                 .build();
         return new InMemoryUserDetailsManager(user,admin);
     }
 }
*/
