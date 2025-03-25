package com.example.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/uploads")
public class FileUploadController {

    @PostMapping
    public ResponseEntity<Map<String, String>> uploadFile(@RequestParam("file") MultipartFile file) {
        // Handle file upload logic
        String fileUrl = "https://cdn.example.com/uploads/" + file.getOriginalFilename();
        Map<String, String> response = new HashMap<>();
        response.put("fileUrl", fileUrl);
        return ResponseEntity.ok(response);
    }
}