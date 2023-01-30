package com.youbooking.youbooking.configspringsecurity;


import com.youbooking.youbooking.entity.Role;
import com.youbooking.youbooking.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAthFilter jwtAthFilter;
    private final UserService userService;

    @Autowired
    private UserDetailsService userDetailsService;
    @Bean
    @Order(SecurityProperties.BASIC_AUTH_ORDER)
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception{

        http
                .csrf().disable().cors().disable()//announce
                .authorizeRequests()//.anyRequest().permitAll();
//                .antMatchers("/**/auth/addProduct","/**/product/addproduct","/**/product/add","/**/product/new").hasRole(Role.ADMIN.toString())
                .antMatchers("/**/auth/**").permitAll()
//                .antMatchers("/**/proprietary/**").hasRole(Role.PROPRIETARY.toString())
                .antMatchers("/**/chambers/**").permitAll()
//                .antMatchers("/**/admin/**").hasRole(Role.ADMIN.toString())
                .antMatchers("/**/reserve/**").hasRole(Role.CLIENT.toString())
                .antMatchers("/**/announce/**").hasRole(Role.PROPRIETARY.toString())
                .antMatchers("/**/client/me" ,"/**/client/profile" ,"/**/client/my_profile").hasRole(Role.CLIENT.toString())
                .antMatchers("/**/client/addClient").permitAll()
                .antMatchers("/**/client/Clients","/**/client/","/**/client/all","/**/client/clients" , "/**/client/{client_id}").hasRole(Role.ADMIN.toString())
                .and()
                .userDetailsService(userDetailsService)
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authenticationProvider(authenticationProvider())
                .addFilterBefore(jwtAthFilter, UsernamePasswordAuthenticationFilter.class)
                ;
//                .httpBasic();
//        http.formLogin();
//        http.httpBasic();
        return http.build();


    }

    @Bean
    public UserDetailsService userDetailsService(){
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
               return userService.loadUserByUsername(email);

            }
        };
    }
    @Bean
    public AuthenticationProvider authenticationProvider(){
        final DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config)throws Exception{
        return config.getAuthenticationManager();
    }
    public PasswordEncoder passwordEncoder() {
//        return NoOpPasswordEncoder.getInstance();
        return new BCryptPasswordEncoder();
    }
}
