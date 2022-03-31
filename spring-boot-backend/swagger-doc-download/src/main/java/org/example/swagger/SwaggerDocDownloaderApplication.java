package org.example.swagger;

import org.example.scheduled.DataImportScheduledTask;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;


@ComponentScan(basePackages = "org.example")
@EntityScan(basePackages = "org.example")
@EnableJpaRepositories(basePackages = "org.example")
@SpringBootApplication(scanBasePackages = "org.example")
public class SwaggerDocDownloaderApplication {

    public static void main(String[] args){
        SpringApplication.run(SwaggerDocDownloaderApplication.class,args);
    }

}
