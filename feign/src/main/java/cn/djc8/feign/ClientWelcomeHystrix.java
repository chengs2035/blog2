package cn.djc8.feign;

import org.springframework.stereotype.Component;

@Component
public class ClientWelcomeHystrix implements IClientWelcome{

    @Override
    public String welcomeFromClientOne(String name) {
       return "welcomeFromClientOne:Error:"+name;
    }
}
