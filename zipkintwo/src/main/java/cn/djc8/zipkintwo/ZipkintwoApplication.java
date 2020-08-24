package cn.djc8.zipkintwo;

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
public class ZipkintwoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZipkintwoApplication.class, args);
    }

    @RequestMapping("/getzipkintwo")
    public String getzipkintwo(){
        return "hi i'm zipkintwo!";
    }

    @RequestMapping("/info")
    public String info(){
        return restTemplate.getForObject("http://zipkinfirst/info",String.class);
    }

    @Autowired
    private RestTemplate restTemplate;

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }


    @Bean
    public Sampler defaultSampler() {
        return Sampler.ALWAYS_SAMPLE;
    }

}
