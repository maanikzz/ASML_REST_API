package com.ASML.SpringbootDownload.service;

import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;

import com.ASML.SpringbootDownload.constants.MessageConstants;

@Service
public class FileServiceImpl implements FilseService{

    @Value("${asml.path.SCREENSHOT_FILE}") 
    private final Path rootScreenshotFile = Paths.get("${asml.path.SCREENSHOT_FILE}");
    
    @Value("${asml.path.GENERATED_FILE}")
    private final Path rootGeneratedFile = Paths.get("${asml.path.GENERATED_FILE}");
    
    public Path getRootScreenshotFile() {
		return rootScreenshotFile;
	}

	public Path getRootGeneratedFile() {
		return rootGeneratedFile;
	}

	@Override
    public Resource loadScreenshot(String filename) {
        try {
            Path path = rootScreenshotFile.resolve(filename);
            Resource resource = new UrlResource(path.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException(MessageConstants.FILE_NOT_READ);
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    
    @Override
    public Stream<Path> loadAllScreenshot() {
        try {
            return Files.walk(this.rootScreenshotFile, 1).filter(path -> !path.equals(this.rootScreenshotFile)).map(this.rootScreenshotFile::relativize);

        } catch (Exception e) {
            throw new RuntimeException(MessageConstants.FILE_NOT_LOADED);
        }
    }
    
	@Override
    public Resource loadGenerated(String filename) {
        try {
            Path path = rootGeneratedFile.resolve(filename);
            Resource resource = new UrlResource(path.toUri());
            System.out.println(path.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException(MessageConstants.FILE_NOT_READ);
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
   
  
    @Override
    public Stream<Path> loadAllGenerated() {
        try {
            return Files.walk(this.rootGeneratedFile, 1).filter(path -> !path.equals(this.rootGeneratedFile)).map(this.rootGeneratedFile::relativize);

        } catch (Exception e) {
            throw new RuntimeException(MessageConstants.FILE_NOT_LOADED);
        }
    }


}
