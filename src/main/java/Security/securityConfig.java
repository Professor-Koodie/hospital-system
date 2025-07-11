package Security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableWebSecurity
@Configuration
public class securityConfig {

   /*  FilterSecurityChain filterSecurityChain(HttpSecurity http) throws Exception{
        return http
                    
                    .build();
    }
    */
}
