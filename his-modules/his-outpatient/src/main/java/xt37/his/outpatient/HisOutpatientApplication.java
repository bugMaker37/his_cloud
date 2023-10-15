package xt37.his.outpatient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import xt37.his.common.security.annotation.EnableCustomConfig;
import xt37.his.common.security.annotation.EnableRyFeignClients;
import xt37.his.common.swagger.annotation.EnableCustomSwagger2;

@EnableCustomConfig
@EnableCustomSwagger2
@EnableRyFeignClients
@SpringBootApplication
public class HisOutpatientApplication {
    public static void main(String[] args) {
        SpringApplication.run(HisOutpatientApplication.class);
    }
}
