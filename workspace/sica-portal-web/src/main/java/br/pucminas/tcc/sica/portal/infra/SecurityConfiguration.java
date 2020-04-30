package br.pucminas.tcc.sica.portal.infra;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.*;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.AuthenticationEntryPoint;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/", "/error", "/home", "/built/**", "/css/**", "/img/**", "/favicon.ico", "/*.*").permitAll()
                .antMatchers(HttpMethod.OPTIONS, "/**")
                .permitAll()
                .anyRequest().authenticated()
                .and()
                .httpBasic()
                .authenticationEntryPoint(authenticationEntryPoint());
    }

    private AuthenticationEntryPoint authenticationEntryPoint() {
        return (request, response, exception) -> {
            if (request.getRequestURI().matches("^/(?!api|.+\\\\..+).+$")) {
                System.out.println(request.getRequestURI() + " será redirecionado para /");
                response.sendRedirect("/");
            } else {
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, exception.getMessage());
            }
        };
    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        UserDetails usuarioEngenharia = User.withDefaultPasswordEncoder()
                .username("engenheiro")
                .password("engenheiro")
                .roles("ENGENHARIA")
                .build();

        return new InMemoryUserDetailsManager(usuarioEngenharia);
    }
}
