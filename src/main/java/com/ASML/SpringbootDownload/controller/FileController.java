package com.ASML.SpringbootDownload.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import com.ASML.SpringbootDownload.model.FileInfo;
import com.ASML.SpringbootDownload.model.ImageWrapper;
import com.ASML.SpringbootDownload.service.FilseService;

@RestController
@RequestMapping("/ASML-REST-SERVICE")
public class FileController 
{
	@Autowired
    FilseService fileService;
	    @GetMapping("/screenshots")
	    public ResponseEntity<List<ImageWrapper>> getAllScreenshots() {
	        List<FileInfo> fileInfoList = fileService.loadAllScreenshot().map(path -> {
	            String fileName = path.getFileName().toString();
	            String url = MvcUriComponentsBuilder.fromMethodName(FileController.class, "getScreenshot",
	                    path.getFileName().toString()).build().toString();
	            return new FileInfo(fileName, url);


	        }).collect(Collectors.toList());
	        
	        List<ImageWrapper> img= new ArrayList<ImageWrapper>();
	        img.add(new ImageWrapper(fileInfoList));
	        return ResponseEntity.status(HttpStatus.OK).body(img);
	    }
	    
	    @GetMapping("/generated_images")
	    public ResponseEntity<List<ImageWrapper>> getAllGeneratedImages() {
	        List<FileInfo> fileInfoList = fileService.loadAllGenerated().map(path -> {
	            String fileName = path.getFileName().toString();
	            String url = MvcUriComponentsBuilder.fromMethodName(FileController.class, "getGenerated",
	                    path.getFileName().toString()).build().toString();
	            return new FileInfo(fileName, url);

	        }).collect(Collectors.toList());
	        
	        List<ImageWrapper> img= new ArrayList<ImageWrapper>();
	        img.add(new ImageWrapper(fileInfoList));
	        return ResponseEntity.status(HttpStatus.OK).body(img);
	    }
	    
	 
	 @GetMapping("/screenshots/{filename}")
	    public ResponseEntity<Resource> getScreenshot(@PathVariable String filename) {
	        Resource file = fileService.loadScreenshot(filename);
	        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
	                "attachment;filename=\"" + file.getFilename() + "\"").body(file);

	    }
	 
	 @GetMapping("/generated_images/{filename}")
	    public ResponseEntity<Resource> getGenerated(@PathVariable String filename) {
	        Resource file = fileService.loadGenerated(filename);
	        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
	                "attachment;filename=\"" + file.getFilename() + "\"").body(file);

	    }
 
}