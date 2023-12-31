package com.collicode.foodorderback.service;


import com.collicode.foodorderback.model.Image;
import com.collicode.foodorderback.repository.FileSystemRepository;
import com.collicode.foodorderback.repository.ImageDbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class FileLocationService {
	
	@Autowired
    FileSystemRepository fileSystemRepository;
    @Autowired
    ImageDbRepository imageDbRepository;

    public Long save(byte[] bytes, String imageName) throws Exception {
        String location = fileSystemRepository.save(bytes, imageName);
        

        return imageDbRepository.save(new Image(imageName, location))
            .getId();
    }
    
    public FileSystemResource find(Long imageId) {
        Image image = imageDbRepository.findById(imageId)
          .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        return fileSystemRepository.findInFileSystem(image.getLocation());
    }

}
