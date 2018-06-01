package com.xw.cbm.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ConfigurationProperties
@ComponentScan(basePackages = {"com.xw.cbm"})
public class CbmApplication {

	public static void main(String[] args) throws Exception {
        SpringApplication.run(CbmApplication.class, args);
   }
}
