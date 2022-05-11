package com.hoangbui.shopping;

import com.hoangbui.shopping.common.config.StorageProperties;
import com.hoangbui.shopping.common.service.FileStoreService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableConfigurationProperties(StorageProperties.class)
public class ShoppingApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShoppingApplication.class, args);
    }

    @Bean
    CommandLineRunner init(FileStoreService fileStoreService) {
        return (args) -> {
            fileStoreService.deleteAll();
            fileStoreService.init();
        };
    }

}
