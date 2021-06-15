package com.ASML.SpringbootDownload;
import javax.annotation.Resource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ASML.SpringbootDownload.service.FilseService;

@SpringBootApplication
public class SpringbootDownloadApplication {

    @Resource
    FilseService fileService;
    
    private static Logger LOGGER = LogManager.getLogger(SpringbootDownloadApplication.class);
    
	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootDownloadApplication.class, args);
		LOGGER.info("Proceed to fetch Screenshots and Generated images");
		
	}

}
