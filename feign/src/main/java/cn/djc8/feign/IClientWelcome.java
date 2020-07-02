package cn.djc8.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//客户端（消费者）
@FeignClient(value="eurekaclient",fallback = ClientWelcomeHystrix.class)
public interface IClientWelcome {

    //具体的接口。 restful
    @RequestMapping(value="/welcome",method=RequestMethod.GET)
    String welcomeFromClientOne(@RequestParam(value="name") String name);

}
