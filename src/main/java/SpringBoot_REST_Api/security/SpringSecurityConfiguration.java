package SpringBoot_REST_Api.security;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//		1) All requests should be authenticated
        http.authorizeHttpRequests(
                auth -> auth.anyRequest().authenticated()
        );
//		2) If a request is not authenticated, a web page is shown , but we want to change that behavior to show basic HTTP auth (a popup)
        http.httpBasic(withDefaults());

        /*
        Starting from Spring Security 4.x, the CSRF protection is enabled by default.
        This default configuration adds the CSRF token to the HttpServletRequest attribute named _csrf.
        If we need to, we can disable this configuration:
        http.csrf(AbstractHttpConfigurer::disable);
        */
        return http.build();
    }
}
