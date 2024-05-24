package com.example.springbootbackendserver.entity;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class DrugRelatedCrimesRecords extends Records{
    @Embedded
    private DrugRelatedCrimesCaseDetail caseDetail;
}
