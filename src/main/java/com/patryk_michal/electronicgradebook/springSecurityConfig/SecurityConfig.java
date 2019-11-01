package com.patryk_michal.electronicgradebook.springSecurityConfig;
//

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/headAdmin").hasAnyAuthority("HEAD_ADMIN")
                .antMatchers("/admin").hasAnyAuthority("HEAD_ADMIN","ADMIN")
                .antMatchers("/teacher").hasAnyAuthority("HEAD_ADMIN","ADMIN","TEACHER")
                .antMatchers("/parent").hasAnyAuthority("HEAD_ADMIN","ADMIN","TEACHER","PARENT")
                .antMatchers("/student").hasAnyAuthority("HEAD_ADMIN","ADMIN","TEACHER","PARENT","STUDENT")
                .anyRequest().permitAll()
                .and().formLogin();
    }

    protected void configure(AuthenticationManagerBuilder auth) throws Exception{

        auth.jdbcAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance())
                .usersByUsernameQuery("SELECT u.login, u.password, 1 from admin u where u.login=?")
                .authoritiesByUsernameQuery("SELECT u.login , u.ROLE, 1 from admin u where u.login=?")
                .dataSource(jdbcTemplate.getDataSource());

        auth.jdbcAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance())
                .usersByUsernameQuery("SELECT u.login,u.password,1 from head_admin u where u.login=?")
                .authoritiesByUsernameQuery("SELECT u.login,u.ROLE,1 from head_admin u where u.login=?")
                .dataSource(jdbcTemplate.getDataSource());

        auth.jdbcAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance())
                .usersByUsernameQuery("SELECT u.login,u.password,1 from teacher u where u.login=?")
                .authoritiesByUsernameQuery("SELECT u.login,u.ROLE,1 from teacher u where u.login=?")
                .dataSource(jdbcTemplate.getDataSource());

        auth.jdbcAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance())
                .usersByUsernameQuery("SELECT u.login,u.password,1 from parent u where u.login=?")
                .authoritiesByUsernameQuery("SELECT u.login,u.ROLE,1 from parent u where u.login=?")
                .dataSource(jdbcTemplate.getDataSource());

        auth.jdbcAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance())
                .usersByUsernameQuery("SELECT u.login,u.password,1 from student u where u.login=?")
                .authoritiesByUsernameQuery("SELECT u.login,u.ROLE,1 from student u where u.login=?")
                .dataSource(jdbcTemplate.getDataSource());

    }

}
