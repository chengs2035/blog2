package cn.djc8.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeCtl {
    @Autowired
    IClientWelcome iclientWelcome;

    @GetMapping(value="/welcome")
    public String welcome(@RequestParam(defaultValue = "com.djc8") String name){
        return iclientWelcome.welcomeFromClientOne(name);
    }
}
