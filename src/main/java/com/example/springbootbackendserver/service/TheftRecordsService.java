package com.example.springbootbackendserver.service;

import com.example.springbootbackendserver.entity.TheftRecords;
import com.example.springbootbackendserver.repository.TheftRecordsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TheftRecordsService {

    @Autowired
    private TheftRecordsRepository theftRecordsRepository;

    public TheftRecords createTheftRecord(TheftRecords theftRecord) {
        return theftRecordsRepository.save(theftRecord);
    }

    public TheftRecords getTheftRecordById(String id) {
        return theftRecordsRepository.findById(id).orElse(null);
    }
}

