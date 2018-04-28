package ru.zhukov.tradeunion.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@Configuration
@EnableWebSecurity

@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {



    @Autowired
    private UserDetailsService myUserDetailService;

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                 .authorizeRequests()
                  .antMatchers("/css/**","/resources/", "/webjars/","/assets/","/js/**")
                  .permitAll()
                .antMatchers("/").permitAll()

                .antMatchers("/oauth/authorize").permitAll()
                .and()
                 .authorizeRequests()
                .anyRequest().authenticated();
                /*.and()
                .formLogin().permitAll();*/


                //.anyRequest()
              // .fullyAuthenticated().and().formLogin();//.loginPage("/login")
               //.failureUrl("/login?error").permitAll().and().logout().permitAll();
    }
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("user")
                 .roles("USER")
                .password("{noop}password");
    }

    @Autowired
    public void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailService);
                //.passwordEncoder(encoder());
    }

    private BCryptPasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

}
