package com.ASML.SpringbootDownload;

import javax.annotation.Resource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ASML.SpringbootDownload.service.FilseService;

@SpringBootApplication
public class SpringbootDownloadApplication {

    @Resource
    FilseService fileService; 
	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootDownloadApplication.class, args);
	}

}
