package com.example.backend.controller;

import com.example.backend.dto.DataDTO;
import com.example.backend.service.DataService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/data")
public class DataController {

    private final DataService dataService;

    public DataController(DataService dataService) {
        this.dataService = dataService;
    }

    @GetMapping
    public ResponseEntity<Page<DataDTO>> getAllData(@RequestParam int page, @RequestParam int size) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(dataService.getAllData(pageable));
    }

    @PostMapping
    public ResponseEntity<DataDTO> createData(@RequestBody DataDTO dataDTO) {
        return ResponseEntity.ok(dataService.createData(dataDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DataDTO> updateData(@PathVariable Long id, @RequestBody DataDTO dataDTO) {
        return ResponseEntity.ok(dataService.updateData(id, dataDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteData(@PathVariable Long id) {
        dataService.deleteData(id);
        return ResponseEntity.noContent().build();
    }
}