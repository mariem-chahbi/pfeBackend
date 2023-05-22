package com.creche.crecheapp.controller;/*package com.creche.crecheapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FileDownloadControllerFile {
	@Autowired
	private DatabaseFileService fileStorageService;
	@GetMapping("/downloadFile/{fileId:.+}")
	public ResponseEntity<Resource> downloadFile(@PathVariable String fileId, HttpServletRequest request) {
		// Load file as Resource
		DatabaseFile databaseFile = fileStorageService.getFile(fileId);
		
		return  ResponseEntity.ok().contentType(MediaType.parseMediaType(databaseFile.getFileType()))
				.header(HttpHeaders.CONTENT_DISPOSITION,"attachement; fileName\"" +databaseFile.getFileName() + "\"")
		.body(new ByteArrayResource(databaseFile.getData()));
		
		
	
	
	
	}
	
	
	
	
	

}
*/