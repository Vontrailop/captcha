package captchaservice.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CaptchaService {

    @Autowired
    private RestTemplate restTemplate;

    public boolean verificarCaptcha(String token) {
        String url = "URL_DEL_SERVIDOR_DE_VERIFICACION_DE_CAPTCHA" + token; // Reemplaza con la URL adecuada
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        // Analizar la respuesta para verificar el captcha
        // Por ejemplo, puedes verificar el cuerpo de la respuesta
        if (response.getBody() != null && response.getBody().contains("captcha_valido")) {
            return true;
        } else {
            return false;
        }
    }
}