package com.example.backend.service;

import com.example.backend.dto.DataDTO;
import com.example.backend.repository.DataRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DataService {

    private final DataRepository dataRepository;

    public DataService(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    public Page<DataDTO> getAllData(Pageable pageable) {
        return dataRepository.findAll(pageable).map(this::convertToDTO);
    }

    private DataDTO convertToDTO(Data data) {
        // Conversion logic here
        return new DataDTO();
    }
}