package com.creche.crecheapp.typefile.controller;


import com.creche.crecheapp.typefile.message.ResponseMessage;
import com.creche.crecheapp.typefile.model.FileInfo;
import com.creche.crecheapp.typefile.service.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.stream.Stream;

@Controller
@CrossOrigin("http://localhost:8081")
@RequestMapping("/api/v1/file")
public class FileController {
  @Autowired
  FileStorageService storageService;

  @PostMapping("/upload")
  public Mono<ResponseEntity<ResponseMessage>> uploadFile(@RequestPart("file") Mono<FilePart> filePartMono) {
    return storageService.save(filePartMono).map(
        (filename) -> ResponseEntity.ok().body(new ResponseMessage("Uploaded the file successfully: " + filename)));
  }

  @GetMapping("/files")
  public ResponseEntity<Flux<FileInfo>> getListFiles() {
    Stream<FileInfo> fileInfoStream = storageService.loadAll().map(path -> {
      String filename = path.getFileName().toString();
      String url = UriComponentsBuilder.newInstance().path("/files/{filename}").buildAndExpand(filename).toUriString();
      return new FileInfo(filename, url);
    });

    Flux<FileInfo> fileInfosFlux = Flux.fromStream(fileInfoStream);

    return ResponseEntity.status(HttpStatus.OK).body(fileInfosFlux);
  }

  @GetMapping("/files/{filename:.+}")
  public ResponseEntity<Flux<DataBuffer>> getFile(@PathVariable String filename) {
    Flux<DataBuffer> file = storageService.load(filename);

    return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + filename + "\"")
        .contentType(MediaType.APPLICATION_OCTET_STREAM).body(file);
  }

  @DeleteMapping("/files/{filename:.+}")
  public Mono<ResponseEntity<ResponseMessage>> deleteFile(@PathVariable String filename) {
    String message = "";

    try {
      boolean existed = storageService.delete(filename);

      if (existed) {
        message = "Delete the file successfully: " + filename;
        return Mono.just(ResponseEntity.ok().body(new ResponseMessage(message)));
      }

      message = "The file does not exist!";
      return Mono.just(ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseMessage(message)));
    } catch (Exception e) {
      message = "Could not delete the file: " + filename + ". Error: " + e.getMessage();
      return Mono.just(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseMessage(message)));
    }
  }
}
