package com.example.springbootbackendserver.repository;

import com.example.springbootbackendserver.entity.TheftRecords;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheftRecordsRepository extends JpaRepository<TheftRecords, String> {
}
