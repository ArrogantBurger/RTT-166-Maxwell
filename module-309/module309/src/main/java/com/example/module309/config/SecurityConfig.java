package com.example.module309.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        // for preventing automated bots, helps increase human engagement
        http.csrf(csrf -> csrf.disable());

        http.authorizeRequests()
                .requestMatchers(
                        new AntPathRequestMatcher("/customer/**"),
                        new AntPathRequestMatcher("/employee/**")).authenticated()
                .anyRequest().permitAll();

        http.formLogin(formLogin -> formLogin
                // URL for login page, requires controller method to listen and show the login page
                // analogous to customer and page is login
                .loginPage("/login/login")
                // Spring security has this controller method created for us already
                // we're just configuring the URL where it submits to
                .loginProcessingUrl("/login/login"));

        http.logout(formLogout -> formLogout
                .invalidateHttpSession(true)
                // Actual URL implemented by Spring security, we specify GetMapping for it
                .logoutUrl("login/logout")
                // Where does the user go after they have been logged out?
                // This is a URL that we have implemented somewhere in our project or controllers
                .logoutSuccessUrl("/")
                // extra security, eliminate cookies on logout
                .deleteCookies("username", "JSESSIONID"));

        return http.build();
    }

}
