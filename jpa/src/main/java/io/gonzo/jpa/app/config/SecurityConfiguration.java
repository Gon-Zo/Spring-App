package io.gonzo.jpa.app.config;

import io.gonzo.jpa.app.config.security.filter.CustomAfterFilter;
import io.gonzo.jpa.app.config.security.filter.CustomBeforeFilter;
import io.gonzo.jpa.app.config.security.filter.CustomFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.GenericFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final AuthenticationFailureHandler authenticationFailureHandler;

    private final AuthenticationSuccessHandler authenticationSuccessHandler;

    private final LogoutSuccessHandler logoutSuccessHandler;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers(HttpMethod.OPTIONS, "/**")
                .antMatchers("/h2-console/**")
        ;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.addFilterBefore(new CustomBeforeFilter(), BasicAuthenticationFilter.class)
                .addFilterAfter(new CustomAfterFilter(), BasicAuthenticationFilter.class);

        http.authorizeRequests()
                .antMatchers("/**")
                .authenticated()
                .antMatchers("/api/**")
                .authenticated()
                .antMatchers("/admin")
                .access("hasRole('ADMIN')")
                .antMatchers("/system")
                .hasRole("SYSTEM")
                .antMatchers("/user")
                .hasAnyRole("USER");

        http.formLogin()
                .loginProcessingUrl("/login-progress")
                .successHandler(authenticationSuccessHandler)
                .failureHandler(authenticationFailureHandler)
                .permitAll();

        http.csrf().disable();

        http.logout()
                .logoutUrl("/logout")
                .logoutSuccessHandler(logoutSuccessHandler)
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .deleteCookies("JSESSIONID");
    }

}
