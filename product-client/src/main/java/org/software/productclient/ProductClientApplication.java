package org.software.productclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = {"org.software.productclient.controller","org.software.productclient.Client"})
@EnableEurekaClient
@EnableFeignClients("org.software.productclient.Client")
public class ProductClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductClientApplication.class, args);
    }

}
