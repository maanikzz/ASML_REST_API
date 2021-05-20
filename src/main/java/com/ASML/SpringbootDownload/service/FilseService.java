package com.ASML.SpringbootDownload.service;

import java.nio.file.Path;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FilseService {
  //  void init();

  //  void save(MultipartFile file);

    public Resource load(String filename);


    public Stream<Path> loadAll();

}
