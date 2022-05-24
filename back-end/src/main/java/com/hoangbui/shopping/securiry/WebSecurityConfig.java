package com.hoangbui.shopping.securiry;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
@SuppressWarnings({ "PMD.SignatureDeclareThrowsException" })
@EnableGlobalMethodSecurity(
        securedEnabled = true,
        jsr250Enabled = true,
        prePostEnabled = true
)
@RequiredArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyAccessDeniedHandler myAccessDeniedHandler;

    @Autowired
    private AuthenticationEntryPoint jwtAuthenticationEntryPoint;

    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    @Autowired
    private JwtUserDetailsService jwtUserDetailsService;

    private static final String[] STATIC_RESOURCES = { "/v2/api-docs", "/configuration/ui",
            "/swagger-resources/**", "/configuration/**", "/swagger-ui.html",
            "/webjars/**", "/csrf", "/data/**", "/static/admin/**" };

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        try {
            auth.userDetailsService(jwtUserDetailsService).passwordEncoder(passwordEncoder());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Bean(BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors()
                .and()
                .csrf()
                .disable()
                .authorizeRequests()
                // .antMatchers("/api/order", "/tai-khoan", "/tai-khoan/**",
                // "/api/change-password", "/api/update-profile").authenticated()
                .antMatchers("/api/v1/admin/user/login").permitAll()
                .antMatchers("/api/v1/admin/user/register").permitAll()
                // .antMatchers(HttpMethod.DELETE).hasRole("admin")
                // .antMatchers(HttpMethod.POST).hasRole("admin")
                // .antMatchers(HttpMethod.PUT).hasRole("admin")
//                .antMatchers("/api/v1/admin/**").authenticated()
                .antMatchers("/admin/**", "/api/v1/admin/**").authenticated()
                .anyRequest().permitAll()
                .and()
                .logout()
                .logoutUrl("/api/logout")
                .logoutSuccessUrl("/")
                .deleteCookies("JWT_TOKEN")
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(jwtAuthenticationEntryPoint)
                .and()
                .exceptionHandling()
                .accessDeniedHandler(myAccessDeniedHandler)
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers(STATIC_RESOURCES);
    }
}