package com.creche.crecheapp.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

public class FileDownloadUtil {
  private Path foundFile;

    public Resource getFileAsResource(String fileCode) throws IOException {
        Path dirPath = Paths.get("Files-Upload");

        Files.list(dirPath).forEach(file -> {
            if (file.getFileName().toString().startsWith(fileCode)) {
                foundFile = file;
                return;
            }
        });

        if (foundFile != null) {
            return new UrlResource(foundFile.toUri());
        }

        return null;
    }

      /*  private final Path uploadPath;

    public FileDownloadUtil() {
            uploadPath = Paths.get("Files-Upload");
        }

        public Resource getFileAsResource(String fileCode) throws IOException {
            Optional<Path> foundFile = Files.list(uploadPath)
                    .filter(file -> file.getFileName().toString().startsWith(fileCode))
                    .findFirst();

            if (foundFile.isPresent()) {
                return new UrlResource(foundFile.get().toUri());
            }

            return null;
        }*/
}