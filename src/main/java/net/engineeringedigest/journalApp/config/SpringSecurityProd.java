////package net.engineeringedigest.journalApp.config;
////
////import net.engineeringedigest.journalApp.service.UserDetailsServiceImpl;
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.context.annotation.Bean;
////import org.springframework.context.annotation.Configuration;
////import org.springframework.security.config.Customizer;
////import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
////import org.springframework.security.config.annotation.web.builders.HttpSecurity;
////import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
////import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
////import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
////import org.springframework.security.crypto.password.PasswordEncoder;
////import org.springframework.security.web.SecurityFilterChain;
////
////@Configuration
////@EnableWebSecurity
////public class SpringSecurity extends WebSecurityConfiguration {
////    @Autowired
////    private UserDetailsServiceImpl userDetailsService;
////
////
//////    @Override
//////    protected void configure(HttpSecurity http) throws Exception {
//////        http.authorizeRequests()
//////                .requestMatchers("/journal/**").authenticated()
//////                .anyRequest().permitAll()
//////                .and()
//////                .httpBasic();
//////    }
////
////    @Bean
////    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
////
////
////        return http.authorizeHttpRequests(request -> request
////                        .requestMatchers("/public/**").permitAll()
////                        .requestMatchers("/journal/**").authenticated()
////                        .anyRequest().authenticated())
////                .httpBasic(Customizer.withDefaults())
////                .build();
////    }
////
////
////
////
////    @Autowired
////    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
////        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
////    }
////
////
////    @Bean
////    public PasswordEncoder passwordEncoder(){
////        return new BCryptPasswordEncoder();
////    }
////
////}
//
//
//
//package net.engineeringedigest.journalApp.config;
//
//
//import net.engineeringedigest.journalApp.service.UserDetailsServiceImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Profile;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//
//@Configuration
//@EnableWebSecurity
//@Profile("prod")
//public class SpringSecurityProd {
//
//
//    @Autowired
//    private UserDetailsServiceImpl userDetailsService;
//
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//
//
//        return http.authorizeHttpRequests(request -> request
//                        .requestMatchers("/public/**").authenticated()
//                        .requestMatchers("/journal/**", "/user/**").permitAll()
//                        .requestMatchers("/admin/**").hasRole("ADMIN")
//                        .anyRequest().authenticated())
//                .httpBasic(Customizer.withDefaults())
//                .csrf(AbstractHttpConfigurer::disable)
//                .build();
//    }
//
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
//    }
//
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//}
//
