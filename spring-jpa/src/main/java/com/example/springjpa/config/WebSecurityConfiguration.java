package com.example.springjpa.config;

import com.example.springjpa.core.auth.JwtUtils;
import com.example.springjpa.core.auth.LoginAuthUserDetailsService;
import com.example.springjpa.core.filter.AuthGroupFilter;
import com.example.springjpa.core.filter.JwtAuthFilter;
import com.example.springjpa.core.filter.LoginAuthFilter;
import com.example.springjpa.domain.group.GroupRepository;
import com.example.springjpa.domain.groupmenu.GroupMenuRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

/**
 * Create by park031517@gmail.com on 2020-07-31, 금
 * Blog : https://zzz-oficial.tistory.com
 * Github : https://github.com/Gon-Zo
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final LoginAuthUserDetailsService loginAuthUserDetailsService;

    private final GroupRepository groupRepository;

    private final GroupMenuRepository groupMenuRepository;

    private final JwtUtils jwtUtils;

    public WebSecurityConfiguration(LoginAuthUserDetailsService loginAuthUserDetailsService,
                                    GroupRepository groupRepository,
                                    GroupMenuRepository groupMenuRepository,
                                    JwtUtils jwtUtils){
        this.loginAuthUserDetailsService = loginAuthUserDetailsService;
        this.groupRepository = groupRepository;
        this.groupMenuRepository = groupMenuRepository;
        this.jwtUtils = jwtUtils;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(loginAuthUserDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()

//                .authorizeRequests()
//                .antMatchers("/health/check-up" , "/sign-up")
//                .permitAll()
//                .and()
//                .authorizeRequests()
//                .anyRequest()
//                .authenticated()
//                .and()
                .addFilterAfter(new LoginAuthFilter(authenticationManager(), jwtUtils), UsernamePasswordAuthenticationFilter.class)
                .addFilterAfter(new JwtAuthFilter(jwtUtils, loginAuthUserDetailsService), LoginAuthFilter.class)
                .addFilterAfter(new AuthGroupFilter(groupRepository, groupMenuRepository) , JwtAuthFilter.class)
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers(
                        "/v2/api-docs",
                        "/configuration/ui",
                        "/swagger-resources/**",
                        "/configuration/security",
                        "/swagger-ui.html",
                        "/webjars/**"
                );
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {

        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("HEAD", "GET", "POST", "PUT", "DELETE"));
        configuration.setAllowCredentials(true);
        configuration.setAllowedHeaders(Arrays.asList("Authorization", "TOKEN_ID", "X-Requested-With", "Authorization", "Content-Type", "Content-Length", "Cache-Control"));

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);

        return source;
    }

}
