package com.ASML.SpringbootDownload.controller;

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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
//import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ASML.SpringbootDownload.model.FileInfo;
import com.ASML.SpringbootDownload.service.FilseService;

@RestController
public class FileController 
{
	@Autowired
    FilseService fileService;
	
//	 @GetMapping("/fetch")
//	    public ResponseEntity<List<FileInfo>> getAllFiles() {
//
//	        List<FileInfo> fileInfoList = fileService.loadAll().map(path -> {
//
//	            String fileName = path.getFileName().toString();
//	           //String url = MvcUriComponentsBuilder.fromMethodName(FileController.class, "getFile", path.getFileName().toString()).build().toString();
//	            String url = ServletUriComponentsBuilder
//	                    .fromCurrentContextPath()
//	                    .path("/fetch/")
//	                    .path(path.getFileName().toString())
//	                    .toUriString();
//	            return new FileInfo(fileName, url);
//
//	        }).collect(Collectors.toList());
//
//	        return ResponseEntity.status(HttpStatus.OK).body(fileInfoList);
//	    }
	
	 @GetMapping("/Fetch")
	    public ResponseEntity<List<FileInfo>> getAllFiles() {

	        List<FileInfo> fileInfoList = fileService.loadAll().map(path -> {

	            String fileName = path.getFileName().toString();
	            String url = MvcUriComponentsBuilder.fromMethodName(FileController.class, "getFile",
	                    path.getFileName().toString()).build().toString();
	            return new FileInfo(fileName, url);

	        }).collect(Collectors.toList());

	        return ResponseEntity.status(HttpStatus.OK).body(fileInfoList);
	    }
	 
	 @GetMapping("/Fetch/{filename}")
	    public ResponseEntity<Resource> getFile(@PathVariable String filename) {
	        Resource file = fileService.load(filename);
	        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
	                "attachment;filename=\"" + file.getFilename() + "\"").body(file);

	    }
 


}