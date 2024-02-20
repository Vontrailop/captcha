package captchaservice.captchaservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import captchaservice.Service.CaptchaService;

@RestController
public class CaptchaController {

    @Autowired
    private CaptchaService captchaService;

    @GetMapping("/verificar-captcha")
    public String verificarCaptcha(@RequestParam("token") String token) {
        if (captchaService.verificarCaptcha(token)) {
            return "Captcha válido";
        } else {
            return "Captcha inválido";
        }
    }
}