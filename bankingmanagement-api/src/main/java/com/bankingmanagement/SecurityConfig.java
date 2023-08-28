package com.bankingmanagement;

 import org.springframework.context.annotation.Bean;
 import org.springframework.context.annotation.Configuration;
 import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
 import org.springframework.security.config.annotation.web.builders.HttpSecurity;
 import org.springframework.security.core.userdetails.User;
 import org.springframework.security.core.userdetails.UserDetails;
 import org.springframework.security.provisioning.InMemoryUserDetailsManager;
 import org.springframework.security.web.SecurityFilterChain;

 import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
//@EnableGlobalMethodSecurity(prePostEnabled = true)
 public class SecurityConfig
 {
     @Bean
     public SecurityFilterChain apiFilterChain(HttpSecurity http) throws Exception {
         http
                 .securityMatcher("/api/**")
                 .authorizeHttpRequests(authorize -> authorize
                         .anyRequest().hasAnyRole("ADMIN", "USER")
                 )
                 .httpBasic(withDefaults());
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



