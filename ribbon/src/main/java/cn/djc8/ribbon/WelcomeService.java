package cn.djc8.ribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WelcomeService {
    @Autowired
    RestTemplate restTemplate;

    public String welcomeService(String name) {
        return restTemplate.getForObject("http://eurekaclient/welcome?name="+name,String.class);
    }
}
