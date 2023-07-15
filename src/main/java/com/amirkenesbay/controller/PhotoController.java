package com.amirkenesbay.controller;

import com.amirkenesbay.payload.PhotoDto;
import com.amirkenesbay.service.PhotoService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
@RequestMapping("/photo")
public class PhotoController {
    private final PhotoService photoService;
    @GetMapping("/green")
    public String upload(){
        return "uploadPage";
    }
    @PostMapping("/{id}/upload")
    public ResponseEntity<String> uploadPhoto(@RequestParam("file") MultipartFile file, PhotoDto photoDto, @PathVariable(name = "id") Long Id){
        try {
            photoService.uploadPhoto(photoDto, Id, file);
            return ResponseEntity.ok("Photo uploaded successfully.");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload photo.");
        }

    }
}
