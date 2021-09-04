package io.gonzo.jpa.app.config;

import io.gonzo.jpa.app.config.security.AppFailureHandler;
import io.gonzo.jpa.app.config.security.AppSuccessHandler;
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

//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    /**
     * 패스워드 인코딩
     *
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * 정적 자원 설정
     *
     * @param web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                // Http Method OPTIONS
                .antMatchers(HttpMethod.OPTIONS, "/**")
                // h2 console 추가
                .antMatchers("/h2-console/**")
        ;
    }

    /**
     * Http 설정
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {

//        http
//                .authorizeRequests()
//                .antMatchers("/**")
//                .authenticated()
//                .antMatchers("/api/**")
//                .authenticated()
////                .antMatchers("/**")
////                .permitAll()
//                .and()
//                .formLogin()
//                .loginProcessingUrl("/login-process")
//                .successHandler(appSuccessHandler())
//                .failureHandler(appFailureHandler())
//                .permitAll()
//        ;

        http.csrf().disable().cors().disable();

    }

    @Bean
    public AuthenticationSuccessHandler appSuccessHandler() {
        return new AppSuccessHandler();
    }

    @Bean
    public AuthenticationFailureHandler appFailureHandler() {
        return new AppFailureHandler();
    }
}
