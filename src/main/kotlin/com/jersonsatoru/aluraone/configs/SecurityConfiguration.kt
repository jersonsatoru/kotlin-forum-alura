package com.jersonsatoru.aluraone.configs

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.core.userdetails.UserDetailsService

@Configuration
@EnableWebSecurity
class SecurityConfiguration(
        private val userDetailsService: UserDetailsService,
        private val passwordEncoder: PasswordEncoder
) : WebSecurityConfigurerAdapter() {
    override fun configure(http: HttpSecurity?) {
        http!!.authorizeRequests().antMatchers("/api/topics").hasAuthority("READ_WRITE")
                .anyRequest()
                .authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .formLogin()
                .disable()
                .httpBasic()
    }

    override fun configure(auth: AuthenticationManagerBuilder) {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder.bCryptPasswordEncoder())
    }
}
