package com.example.springbootbackendserver.repository;

import com.example.springbootbackendserver.entity.DrugRelatedCrimesRecords;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DrugRelatedCrimesRecordsRepository extends JpaRepository<DrugRelatedCrimesRecords, String> {
}
