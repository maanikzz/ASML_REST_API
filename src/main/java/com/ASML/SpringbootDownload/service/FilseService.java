package com.ASML.SpringbootDownload.service;

import java.nio.file.Path;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;

public interface FilseService {
    public Resource loadScreenshot(String filename);
    public Resource loadGenerated(String filename);
	public Stream<Path> loadAllScreenshot();
	public Stream<Path> loadAllGenerated();
}
