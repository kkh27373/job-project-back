package com.job.back.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.job.back.filter.JwtAuthenticationFilter;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Autowired private JwtAuthenticationFilter jwtAuthenticationFilter;
    
    @Bean
    protected SecurityFilterChain config(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
            .cors().and()
            .csrf().disable()
            .httpBasic().disable()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                                                             // ^ auth, file만을 허용하는것 
                                                            //  ^ 이 URL 들은 Token이 없어도 허용 
                                                            // ^ 다른 것들은 Token이 있어야 접근가능 
                                                            // ^ 없으면 401 뜬다 
            .authorizeRequests()        //! 공통된 부분이 있으면 상세한 놈이 앞으로 오도록 
                                        // ! 그래야지 1차적으로 많이 걷어낼 수 있다 
                                        //^ authenticated()는 권한이 있는 authorized 된 사람만 사용 가능하다는 뜻 
            .antMatchers("/api/board/my-list").authenticated()
                                        // ^auth : 로그인 이나 회원가입은 누구나 할 수 있어야 하니 
            .antMatchers("/auth/**","/file/**","/web-socket/**","/api/send-mail","/user/validate/**", "/company/validate/**").permitAll()
                                                        // ! 공통된 부분이 있으면 범위가 넓은 놈들이 뒤로 가게 상세한 놈들이 앞으로  
            .antMatchers(HttpMethod.GET,"/api/board/**").permitAll()
            .anyRequest().authenticated().and()
            .exceptionHandling().authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED));

        httpSecurity.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
        
        return httpSecurity.build();
    }

    @Bean
    protected WebSecurityCustomizer webSecurityCustomizer(){
        return (web) -> web.ignoring()
            .antMatchers("/swagger-ui.html","/swagger-resources/**","/swagger/**","/v2/api-docs","/webjars/**");
    }

}