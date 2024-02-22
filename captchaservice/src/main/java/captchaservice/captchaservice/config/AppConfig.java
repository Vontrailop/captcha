package captchaservice.captchaservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {
    // Nuestro componente que nos sirve para hacer envío
    // de información a otras API's
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
