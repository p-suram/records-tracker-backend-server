package com.example.springbootbackendserver.repository;

import com.example.springbootbackendserver.entity.HomicideRecords;
import com.example.springbootbackendserver.entity.TheftRecords;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TheftRecordsRepository extends JpaRepository<TheftRecords, String> {
    List<TheftRecords> findByAddressLatitudeBetweenAndAddressLongitudeBetween(double minLat, double maxLat, double minLon, double maxLon);
}
