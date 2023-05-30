package com.creche.crecheapp.file;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Paths;

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

import javax.validation.Path;


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
    }


/*
    @PostMapping("/uploadFileByActivityId/{activityId}")
=======

  /*  @PostMapping("/uploadFileByActivityId/{activityId}")
>>>>>>> 2b2c4f34e68e49ecb2c40213e72724d73486602f
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


}
