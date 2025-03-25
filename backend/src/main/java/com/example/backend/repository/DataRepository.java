package com.example.backend.repository;

import com.example.backend.entity.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DataRepository extends JpaRepository<Data, Long>, JpaSpecificationExecutor<Data> {
}