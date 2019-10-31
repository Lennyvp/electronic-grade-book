package com.patryk_michal.electronicgradebook.springSecurityConfig;

import com.patryk_michal.electronicgradebook.springSecurityConfig.forTesting.SomeTestModels;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


//compile("org.springframework.boot:spring-boot-starter-security") ->dodalem zaleznosc

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //paru przykladowych uzytkownikow, ktorzy sa przechowywani w pamieci
    @Autowired
    SomeTestModels someTestModels;

    //nadanie roli dla przykladowych uzytkownikow
    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails headAdmin = User.withDefaultPasswordEncoder()
                .username(someTestModels.getHeadAdmin().getLogin())
                .password(someTestModels.getHeadAdmin().getLogin())
                .roles("HEAD_ADMIN")
                .build();

        UserDetails admin = User.withDefaultPasswordEncoder()
                .username(someTestModels.getAdmin().getLogin())
                .password(someTestModels.getAdmin().getPassword())
                .roles("ADMIN")
                .build();

        UserDetails teacher = User.withDefaultPasswordEncoder()
                .username(someTestModels.getTeacher().getLogin())
                .password(someTestModels.getTeacher().getPassword())
                .roles("TEACHER")
                .build();
        UserDetails parent = User.withDefaultPasswordEncoder()
                .username(someTestModels.getParent().getLogin())
                .password(someTestModels.getParent().getPassword())
                .roles("PARENT")
                .build();
        UserDetails student = User.withDefaultPasswordEncoder()
                .username(someTestModels.getStudent().getLogin())
                .password(someTestModels.getStudent().getPassword())
                .roles("STUDENT")
                .build();

        return new InMemoryUserDetailsManager(headAdmin,admin,teacher,parent,student);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/headAdmin").hasRole("HEAD_ADMIN")
                .antMatchers("/admin").hasAnyRole("HEAD_ADMIN","ADMIN")
                .antMatchers("/teacher").hasAnyRole("HEAD_ADMIN","ADMIN","TEACHER")
                .antMatchers("/parent").hasAnyRole("HEAD_ADMIN","ADMIN","TEACHER","PARENT")
                .antMatchers("/student").hasAnyRole("HEAD_ADMIN","ADMIN","TEACHER","PARENT","STUDENT")
                .and().formLogin().permitAll();
    }
}
