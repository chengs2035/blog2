package cn.djc8.zipkinfirst;

import brave.sampler.Sampler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
@EnableEurekaClient
public class ZipkinfirstApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZipkinfirstApplication.class, args);
    }

    @Autowired
    private RestTemplate restTemplate;

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    /**
     * 调用另外的服务
     * @return
     */
    @RequestMapping("/getzipkintwo")
    public String getzipkintwo(){
        //因为已经注册到注册中心，所以可以直接使用服务名来调用方法
        return restTemplate.getForObject("http://zipkintwo/getzipkintwo", String.class);
    }

    @RequestMapping("/info")
    public String info(){
        return "i'm zipkinfirst interface";

    }

    @Bean
    public Sampler defaultSampler() {
        return Sampler.ALWAYS_SAMPLE;
    }

}
