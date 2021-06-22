package com.springboot.webdata.security;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebSecurityConfig implements WebMvcConfigurer {

    @Configuration
    protected static class ApplicationSecurity extends WebSecurityConfigurerAdapter {

        //@Autowired
        //DataSource dataSource;

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            //in memory implementation
            auth.inMemoryAuthentication()
                    .withUser("vivek").password("{noop}vivek").authorities("user_role").and()
                    .withUser("vivek1").password("{noop}vivek1").authorities("user_role").and()
                    .withUser("vivek2").password("{noop}vivek2").authorities("user_role");

            /*auth.jdbcAuthentication().dataSource(dataSource)
                    .passwordEncoder(NoOpPasswordEncoder.getInstance())
                    .withUser("vivek").password("vivek").authorities("user_role").and()
                    .withUser("vivek1").password("vivek1").authorities("user_role").and()
                    .withUser("vivek2").password("vivek2").authorities("user_role");

             */
        }

   }

}
