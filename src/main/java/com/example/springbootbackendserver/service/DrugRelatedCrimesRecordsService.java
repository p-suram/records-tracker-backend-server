package com.example.springbootbackendserver.service;

import com.example.springbootbackendserver.entity.DrugRelatedCrimesRecords;
import com.example.springbootbackendserver.repository.DrugRelatedCrimesRecordsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DrugRelatedCrimesRecordsService {

    @Autowired
    private DrugRelatedCrimesRecordsRepository drugRelatedCrimesRecordsRepository;

    public DrugRelatedCrimesRecords createDrugRelatedCrimesRecord(DrugRelatedCrimesRecords drugRelatedCrimesRecord) {
        return drugRelatedCrimesRecordsRepository.save(drugRelatedCrimesRecord);
    }

    public DrugRelatedCrimesRecords getDrugRelatedCrimesRecordById(String id) {
        return drugRelatedCrimesRecordsRepository.findById(id).orElse(null);
    }
}

