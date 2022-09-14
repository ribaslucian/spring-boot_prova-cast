package br.com.baseapp.configurations;

import lombok.extern.log4j.Log4j2;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@EnableWebSecurity
@Log4j2
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf()
            .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
            .and()
            .authorizeRequests()
            .antMatchers("/actuator/**").permitAll()
            .anyRequest()
            .authenticated()
            .and()
            .httpBasic()
            .and()
            .formLogin();
                
        //     http
        //       .csrf()
        //       .disable()
        //       .authorizeRequests()
        //       .antMatchers("/api/v1", "/api/v1/**")
        //       .permitAll()
        //       .and()
        //       .httpBasic();
        //   }
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        log.info("Password encoded {}", passwordEncoder.encode("test"));
        auth.inMemoryAuthentication()
                .withUser("lucian")
                .password(passwordEncoder.encode("exomp"))
                .roles("USER", "ADMIN")
                .and()
                .withUser("voce")
                .password(passwordEncoder.encode("exomp"))
                .roles("USER");
    }
}

// import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
// import org.springframework.security.crypto.factory.PasswordEncoderFactories;
// import org.springframework.security.crypto.password.PasswordEncoder;

// @EnableWebSecurity
// public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

//   @Override
//   protected void configure(HttpSecurity http) throws Exception {
//     http
//     .csrf()
//     .disable()
//     .authorizeRequests()
//     // .antMatchers("/api/v1", "/api/v1/**")
//     .anyRequest()
//     // .permitAll()
//     .authenticated()
//     .and()
//     .httpBasic();
//   }

//   @Override
//   protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//     PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

//     auth.inMemoryAuthentication()
//         .withUser("lucian")
//         .password(passwordEncoder.encode("exomp"))
//         .roles("USER", "ADMIN");

//     // TODO Auto-generated method stub
//     super.configure(auth);
//   }

// }
