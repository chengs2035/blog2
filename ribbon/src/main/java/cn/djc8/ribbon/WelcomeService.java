package cn.djc8.ribbon;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WelcomeService {
    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "welcomeError")
    public String welcomeService(String name) {
        return restTemplate.getForObject("http://eurekaclient/welcome?name="+name,String.class);
    }

    public String welcomeError(String name){
        return "welcome:"+name+"but,error";
    }

    public String welcomeError(String name,String error){
        return "welcome:"+name+"but,error"+error;
    }
}
