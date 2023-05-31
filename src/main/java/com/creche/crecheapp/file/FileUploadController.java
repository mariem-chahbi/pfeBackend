package com.creche.crecheapp.file;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.creche.crecheapp.model.*;
import com.creche.crecheapp.repository.ActivityRepository;
import com.creche.crecheapp.repository.ChildRepository;
import com.creche.crecheapp.repository.HomeworkRepository;
import com.creche.crecheapp.repository.PostRepository;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


/*
>>>>>>> a824de55674047248c24ccac4fb271cfa3c0e2c3
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

@RestController
@RequestMapping("/api/v1/file")
public class FileUploadController {

    private List<String> fileUris = new ArrayList<>();

private final ActivityRepository activityRepository;
private  final ChildRepository childRepository;
private  final HomeworkRepository homeworkRepository;
private final PostRepository postRepository;
    private final FileUploadResponseRepository fileUploadResponseRepository;

    public FileUploadController(ActivityRepository activityRepository, ChildRepository childRepository, HomeworkRepository homeworkRepository, PostRepository postRepository, FileUploadResponseRepository fileUploadResponseRepository) {
        this.activityRepository = activityRepository;
        this.childRepository = childRepository;
        this.homeworkRepository = homeworkRepository;
        this.postRepository = postRepository;

        this.fileUploadResponseRepository = fileUploadResponseRepository;
    }
    @PostMapping("/uploadFile/{type}/{id}")
    public ResponseEntity<FileUploadResponse> uploadFile(@RequestParam("file") MultipartFile[] multipartFile, @PathVariable ("type")FileType fileType,@PathVariable ("id")Integer id  ) throws IOException {
        System.out.println("fileType"+fileType+"id"+id);
for (MultipartFile file : multipartFile) {
    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
    long size = file.getSize();

    String filecode = FileUploadUtil.saveFile(fileName, file);

    FileUploadResponse response = new FileUploadResponse();
    response.setFileName(fileName);
    response.setSize(size);
    System.out.println("size"+size);
    System.out.println("multipartFile"+file);
    response.setDownloadUri("/downloadFile/" + filecode);


    FileUploadResponse savedResponse = fileUploadResponseRepository.save(response); // Save the entity to the repository
    switch (fileType) {
        case ACTIVITY:
            Activity activity = activityRepository.findActivityById(id);
            System.out.println("activity" + activity);
            if (activity.fileUrl == "") {
                activity.setFileUrl(filecode);
            }else {
                activity.setFileUrl(activity.getFileUrl() + "," + filecode);
            }

            activityRepository.save(activity);
            System.out.println("response" + savedResponse.getDownloadUri());
            break;
        case CHILD:
            Child child = childRepository.findChildById(id);
            System.out.println("child" + child);
            if (child.fileUrl == "") {
                child.setFileUrl(filecode);
            }else {
                child.setFileUrl(child.getFileUrl() + "," + filecode);
            }

            childRepository.save(child);
            System.out.println("response" + savedResponse.getDownloadUri());
            break;
        case POST:
            Post post = postRepository.findPostById(id);
            System.out.println("post" + post);
            if (post.fileUrl == "") {
                post.setFileUrl(filecode);
            }else {
                post.setFileUrl(post.getFileUrl() + "," + filecode);
            }

            postRepository.save(post);
            System.out.println("response" + savedResponse.getDownloadUri());
            break;
        case HOMEWORK:
            Homework homework = homeworkRepository.findHomeworkById(id);
            System.out.println("homework" + homework);
            if (homework.fileUrl == "") {
                homework.setFileUrl(filecode);
            }else {
                homework.setFileUrl(homework.getFileUrl() + "," + filecode);
            }

            homeworkRepository.save(homework);
            System.out.println("response" + savedResponse.getDownloadUri());
            break;
    }
}

            return new ResponseEntity<>( HttpStatus.OK);
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
