package com.amirkenesbay.service;

import com.amirkenesbay.entity.Photo;
import com.amirkenesbay.entity.User;
import com.amirkenesbay.exception.ResourceNotFoundException;
import com.amirkenesbay.payload.PhotoDto;
import com.amirkenesbay.repository.PhotoRepository;
import com.amirkenesbay.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class PhotoService {
    private final PhotoRepository photoRepository;
    private final UserRepository userRepository;

    public PhotoService(PhotoRepository photoRepository, UserRepository userRepository) {
        this.photoRepository = photoRepository;
        this.userRepository = userRepository;
    }
    public String uploadPhoto(PhotoDto photoDto, Long userId, MultipartFile file)throws IOException {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        Photo photo = new Photo();
        photo.setId(photoDto.getId());
        photo.setImageData(file.getBytes());
        photo.setDescription(photoDto.getDescription());
        photo.setFilename(file.getOriginalFilename());
        photo.setUser(user);
        photoRepository.save(photo);

        return "Uploading photo done";
    }
}
