package com.creche.crecheapp.typefile.service;

import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.codec.multipart.FilePart;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.nio.file.Path;
import java.util.stream.Stream;

public interface FileStorageService {
  public void init();

  public Mono<String> save(Mono<FilePart> filePartMono);

  public Flux<DataBuffer> load(String filename);

  public boolean delete(String filename);

  public Stream<Path> loadAll();
}
