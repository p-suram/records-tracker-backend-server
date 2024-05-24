package com.example.springbootbackendserver.entity;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TheftRecords extends Records{
    @Embedded
    private TheftCaseDetail caseDetail;
}