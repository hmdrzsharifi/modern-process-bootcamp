//package com.caribou.bank.config;
//
//import com.caribou.bank.security.AuthenticationFilter;
//import com.caribou.bank.security.LoginFilter;
//import com.caribou.bank.security.UserDetailServiceImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.CorsConfigurationSource;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//
//import java.util.Arrays;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    private UserDetailServiceImpl userDetailsService;
//
//    @Override
//    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//            .userDetailsService(userDetailsService)
//            .passwordEncoder(passwordEncoder());
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder()
//    {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public WebSecurityCustomizer webSecurityCustomizer() {
//        return web ->
//                web
//                        .ignoring()
////                        .antMatchers(HttpMethod.OPTIONS, "/**")
////                        .antMatchers("/app/**/*.{js,html}")
////                        .antMatchers("/i18n/**")
////                        .antMatchers("/content/**")
//                        .antMatchers("/h2-console/**")
//                        .antMatchers("/v2/api-docs/**")
//                        .antMatchers("/swagger-ui/**")
//                        .antMatchers("/swagger-resources/**");
////                        .antMatchers("/test/**")                     ;
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable()
//            .cors().configurationSource(corsConfigurationSource())
//            .and()
//            .authorizeRequests()
//            .antMatchers(HttpMethod.POST, "/login").permitAll()
//            .antMatchers("/api/register").permitAll()
//            .anyRequest().authenticated()
//            .and()
//            // Filter for the api/login requests
//            .addFilterBefore(new LoginFilter("/login", authenticationManager()),
//              UsernamePasswordAuthenticationFilter.class)
//            // Filter for other requests to check JWT in header
//            .addFilterBefore(new AuthenticationFilter(),
//             UsernamePasswordAuthenticationFilter.class);
//    }
//
//    @Bean
//    CorsConfigurationSource corsConfigurationSource() {
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
////        CorsConfiguration source = new CorsConfiguration();
//        CorsConfiguration config = new CorsConfiguration();
//        config.addAllowedOriginPattern("*");
//        config.setAllowedMethods(Arrays.asList("*"));
//        config.setAllowedHeaders(Arrays.asList("*"));
//        config.setAllowCredentials(true);
//        config.applyPermitDefaultValues();
//
//        source.registerCorsConfiguration("/**", config);
//        return source;
//    }
//}
