package com.example.springbootbackendserver.service;

import com.example.springbootbackendserver.entity.VehicularCrimesRecords;
import com.example.springbootbackendserver.repository.VehicularCrimesRecordsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicularCrimesRecordsService {

    @Autowired
    private VehicularCrimesRecordsRepository vehicularCrimesRecordsRepository;

    public VehicularCrimesRecords createVehicularCrimesRecord(VehicularCrimesRecords vehicularCrimesRecord) {
        return vehicularCrimesRecordsRepository.save(vehicularCrimesRecord);
    }

    public VehicularCrimesRecords getVehicularCrimesRecordById(String id) {
        return vehicularCrimesRecordsRepository.findById(id).orElse(null);
    }
}

