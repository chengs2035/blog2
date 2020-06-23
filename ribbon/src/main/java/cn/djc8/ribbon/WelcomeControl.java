package cn.djc8.ribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeControl {
    @Autowired
    WelcomeService welcomeService;

    @GetMapping(value = "/welcome")
    public String welcome(@RequestParam(defaultValue = "username") String name){
        return welcomeService.welcomeService(name);
    }
}
