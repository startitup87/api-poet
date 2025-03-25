package com.example.backend.service;

import com.example.backend.dto.DataDTO;
import com.example.backend.entity.Data;
import com.example.backend.exception.ResourceNotFoundException;
import com.example.backend.repository.DataRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class DataService {
    private final DataRepository dataRepository;

    public DataService(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    public Page<DataDTO> getAllData(Pageable pageable) {
        return dataRepository.findAll(pageable)
                .map(this::convertToDTO);
    }
    
    public Page<DataDTO> getAllData(Pageable pageable, String category, Double maxPrice, String search) {
        Specification<Data> spec = Specification.where(null);
        // Implementation would go here
        return dataRepository.findAll(spec, pageable)
                .map(this::convertToDTO);
    }
    
    public DataDTO getDataById(Long id) {
        return dataRepository.findById(id)
                .map(this::convertToDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Data not found"));
    }
    
    public DataDTO createData(DataDTO dataDTO) {
        Data data = convertToEntity(dataDTO);
        Data savedData = dataRepository.save(data);
        return convertToDTO(savedData);
    }
    
    public DataDTO updateData(Long id, DataDTO dataDTO) {
        Data data = dataRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Data not found"));
        
        // Update fields
        data.setName(dataDTO.getName());
        data.setDescription(dataDTO.getDescription());
        data.setCategory(dataDTO.getCategory());
        data.setPrice(dataDTO.getPrice());
        
        Data updatedData = dataRepository.save(data);
        return convertToDTO(updatedData);
    }
    
    public void deleteData(Long id) {
        if (!dataRepository.existsById(id)) {
            throw new ResourceNotFoundException("Data not found");
        }
        dataRepository.deleteById(id);
    }

    private DataDTO convertToDTO(Data data) {
        DataDTO dto = new DataDTO();
        dto.setId(data.getId());
        dto.setName(data.getName());
        dto.setDescription(data.getDescription());
        dto.setCategory(data.getCategory());
        dto.setPrice(data.getPrice());
        return dto;
    }
    
    private Data convertToEntity(DataDTO dto) {
        Data data = new Data();
        if (dto.getId() != null) {
            data.setId(dto.getId());
        }
        data.setName(dto.getName());
        data.setDescription(dto.getDescription());
        data.setCategory(data.getCategory());
        data.setPrice(dto.getPrice());
        return data;
    }
}