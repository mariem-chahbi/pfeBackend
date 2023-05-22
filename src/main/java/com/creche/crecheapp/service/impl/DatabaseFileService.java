package com.creche.crecheapp.service.impl;/*package com.creche.crecheapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import tn.esprit.spring.entity.DatabaseFile;
import tn.esprit.spring.entity.Post;
import tn.esprit.spring.exception.FileNotFoundException;
import tn.esprit.spring.exception.FileStorageException;
import tn.esprit.spring.exception.PostNotFoundException;
import tn.esprit.spring.repository.DatabaseFileRepository;

import java.io.IOException;
import java.util.Optional;

@Service
public class DatabaseFileService {
	@Autowired
	DatabaseFileRepository dbFileRepository;
	@Autowired
	IPostService postService;

	public DatabaseFile storeFile(MultipartFile file, int post_id) {
		// Normalize file name
		String fileName = org.springframework.util.StringUtils.cleanPath(file.getOriginalFilename());
		try {
			// Check if the file's name contains invalid characters
			if (fileName.contains("..")) {
				throw new tn.esprit.spring.exception.FileStorageException(
						"Sorry! Filename contains invalid path sequence " + fileName);
			}
			Optional<Post> optionalPost = postService.getById(post_id);
			DatabaseFile dbFile = null;
			if (optionalPost.isPresent()) {
				Post post = optionalPost.get();
				dbFile = new DatabaseFile(fileName, file.getContentType(), file.getBytes(), post);
				return dbFileRepository.save(dbFile);
			} else
				throw new PostNotFoundException("pas de post dans la saisie de l'image");
		} catch (IOException ex) {
			throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
		}

	}

	public DatabaseFile getFile(String fileId) {
		return dbFileRepository.findById(fileId)
				.orElseThrow(() -> new FileNotFoundException("file not found with id " + fileId));

	}

}*/
