package com.creche.crecheapp.file;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.creche.crecheapp.model.Activity;
import com.creche.crecheapp.service.ActivityService;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
/*
@RestController

@RequestMapping("/api/v1/file")
public class FileUploadController {
    private final ActivityService activityService;
    public FileUploadController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @PostMapping("/uploadFile")
    public ResponseEntity<FileUploadResponse> uploadFile(
            @RequestParam("file") MultipartFile multipartFile)
            throws IOException {

        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        long size = multipartFile.getSize();

        String filecode = FileUploadUtil.saveFile(fileName, multipartFile);

        FileUploadResponse response = new FileUploadResponse();
        response.setFileName(fileName);
        response.setSize(size);
        response.setDownloadUri("/downloadFile/" + filecode);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }*/

  /*  @PostMapping("/uploadFileByActivityId/{activityId}")
    public ResponseEntity<?> uploadFileByActivityId(
            @PathVariable("activityId") Integer activityId,
            @RequestParam("file") MultipartFile multipartFile) throws IOException {

        // Retrieve the activity from the database using the activityId
        Activity activity = activityService.getActivityById(activityId);
        if (activity == null) {
            return new ResponseEntity<>("Activity not found", HttpStatus.NOT_FOUND);
        }

        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        long size = multipartFile.getSize();

        String fileCode = FileUploadUtil.saveFile(fileName, multipartFile);

        // Update the activity's file code
        activity.setFilecode(fileCode);
        activityService.saveActivity(activity);

        FileUploadResponse response = new FileUploadResponse();
        response.setFileName(fileName);
        response.setSize(size);
        response.setDownloadUri("/api/v1/file/downloadFile/" + fileCode);

        return ResponseEntity.ok(response);
    }*/



    // Custom logic to retrieve the file code for the activity

@RestController
@RequestMapping("/api/v1/file")
public class FileUploadController {

    private List<String> fileUris = new ArrayList<>();


    private final FileUploadResponseRepository fileUploadResponseRepository;

    public FileUploadController( FileUploadResponseRepository fileUploadResponseRepository) {

        this.fileUploadResponseRepository = fileUploadResponseRepository;
    }
    @PostMapping("/uploadFile")
    public ResponseEntity<FileUploadResponse> uploadFile(@RequestParam("file") MultipartFile multipartFile) throws IOException {
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        long size = multipartFile.getSize();

        String filecode = FileUploadUtil.saveFile(fileName, multipartFile);

        FileUploadResponse response = new FileUploadResponse();
        response.setFileName(fileName);
        response.setSize(size);
        response.setDownloadUri("/downloadFile/" + filecode);


        FileUploadResponse savedResponse = fileUploadResponseRepository.save(response); // Save the entity to the repository

        return new ResponseEntity<>(savedResponse, HttpStatus.OK);
    }


    @GetMapping("/getAllFileUris")
    public ResponseEntity<List<String>> getAllFileUris() {
        return ResponseEntity.ok(fileUris);
    }

    @GetMapping("/getFile/{id}")
    public ResponseEntity<FileUploadResponse> getFile(@PathVariable("id") Long id) {
        Optional<FileUploadResponse> fileUploadResponseOptional = fileUploadResponseRepository.findById(id);

        if (fileUploadResponseOptional.isPresent()) {
            FileUploadResponse fileUploadResponse = fileUploadResponseOptional.get();
            return new ResponseEntity<>(fileUploadResponse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/downloadFile/{fileCode}")
    public ResponseEntity<?> downloadFile(@PathVariable("fileCode") String fileCode) {
        FileDownloadUtil downloadUtil = new FileDownloadUtil();

        Resource resource = null;
        try {
            resource = downloadUtil.getFileAsResource(fileCode);
        } catch (IOException e) {
            return ResponseEntity.internalServerError().build();
        }

        if (resource == null) {
            return new ResponseEntity<>("File not found", HttpStatus.NOT_FOUND);
        }

        String contentType = "application/octet-stream";
        String headerValue = "attachment; filename=\"" + resource.getFilename() + "\"";

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, headerValue)
                .body(resource);
    }

}
