package com.example.rentalcar.security;

import com.example.rentalcar.security.service.UserDetailsServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }



    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("user1").password(passwordEncoder().encode("123"))
//                .authorities("ROLE_USER");
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

//    @Bean
//    @Override
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }

//    @Override
//    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder)
//            throws Exception {
//        authenticationManagerBuilder.userDetailsService(userDetailsService)
//                .passwordEncoder(passwordEncoder());
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();

//         Các trang không yêu cầu login
//        http.authorizeRequests().antMatchers("/", "admin/login","admin/login/subscribers/*").permitAll();

//         Trang /userInfo yêu cầu phải login với vai trò ROLE_USER hoặc ROLE_ADMIN.
//         Nếu chưa login, nó sẽ redirect tới trang /login.
//        http.authorizeRequests().antMatchers("/admin/**").access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')");

//         Trang chỉ dành cho ADMIN
        http.authorizeRequests().antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')");

//         Khi người dùng đã login, với vai trò XX.
//         Nhưng truy cập vào trang yêu cầu vai trò YY,
//         Ngoại lệ AccessDeniedException sẽ ném ra.
//        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");

//         Cấu hình cho Login Form.
//        http.authorizeRequests()
//                .anyRequest().authenticated()
//                .and().formLogin()
//                .loginProcessingUrl("/j_spring_security_check") // Submit URL
//                .loginPage("/admin/login")//
//                .defaultSuccessUrl("/admin/subscribers")//
//                .failureUrl("/login?error=true");
//                .usernameParameter("username")//
//                .passwordParameter("password");
//                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/logoutSuccessful") ;
        http.authorizeRequests().antMatchers(
                        "/login",
                            "/user/register",
                        "/car/searchCar/{name}",
                        "/user/registersubmit",
                        "/web/**",
                        "**/uploads/**",
                        "file.upload-dir",
                        "/assets/**",
                        "/css/**",
                        "/js/**",
                        "/",
                        "/adminlte/**",
                        "/css/**",
                        "/js/**",
                        "/img/**").permitAll()

                .anyRequest().authenticated()
//                .antMatchers("/admin/**").hasAnyRole("ROLE_ADMIN")
                .and()
                .formLogin()
                .loginProcessingUrl("/j_spring_security_check")
                .loginPage("/login")
                .defaultSuccessUrl("/")
                .failureUrl("/admin/login?success=fail")
                .usernameParameter("name")//
                .passwordParameter("password")
                .permitAll().and().logout().logoutUrl("/logout").logoutSuccessUrl("/login");
//                .and()
//                .logout()
//                .invalidateHttpSession(true)
//                .clearAuthentication(true);
//                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//                .logoutSuccessUrl("/login?logout")
//                .permitAll();
    }
}
