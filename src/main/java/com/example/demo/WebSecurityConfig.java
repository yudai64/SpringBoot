package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
  
  @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            // AUTHORIZE
            .authorizeRequests()
            /* */.mvcMatchers("/", "/login/**").permitAll()
            /* */.mvcMatchers("/inquiry/form", "/inquiry/confirm", "/inquiry/save", "/inquiry/complete").permitAll()
            /* */.anyRequest()
            /*    */.authenticated()
            .and()

            // LOGIN
            .formLogin()
            // /* */.loginProcessingUrl("/login")
            /* */.loginPage("/login")
            /* */.successForwardUrl("/success")//認証成功時のURL
            /* */.failureUrl("/login-error")
                        .permitAll()
        // end
        ;
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/favicon.ico", "/css/**", "/js/**", "/images/**", "/fonts/**");
    }
}