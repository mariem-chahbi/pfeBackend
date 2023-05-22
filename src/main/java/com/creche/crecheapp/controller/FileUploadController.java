package com.creche.crecheapp.controller;
/*package com.creche.crecheapp.controller;

=======
package com.creche.crecheapp.controller;
/*
>>>>>>> 52d592a208bfc7719c5142ef04b414da9a20bec6
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class FileUploadController {
	@Autowired
	DatabaseFileService fileStorageService;

//	@PostMapping("/uploadFile/{postId}")
    @RequestMapping(path = "/uploadFile/{postId}", method = RequestMethod.POST, consumes = { "multipart/form-data" })
	public Response uploadFile(@RequestParam("file") MultipartFile file, @RequestParam  int postId) {
		DatabaseFile filename = fileStorageService.storeFile(file, postId);
		String filedownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("downloadFile/")
				.path(filename.getFileName()).toString();
		return new Response(filename.getFileName(), filedownloadUri, file.getContentType(), file.getSize());

	}

	@PostMapping("/uploadMultiFiles")
	public List<Response> uploadMultiFiles(@RequestParam("files") MultipartFile[] files, @RequestParam int postId) {
		return Arrays.asList(files).stream().map(file -> uploadFile(file, postId)).collect(Collectors.toList());
	}

<<<<<<< HEAD
}
*/
