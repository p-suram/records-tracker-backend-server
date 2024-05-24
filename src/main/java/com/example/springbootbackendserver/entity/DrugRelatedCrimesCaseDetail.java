package com.example.springbootbackendserver.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Embeddable
public class DrugRelatedCrimesCaseDetail extends CaseDetail {
    public enum DrugRelatedCrimeType {
        POSSESSION_OF_CONTROLLED_SUBSTANCES,
        DISTRIBUTION_OR_TRAFFICKING_OF_DRUGS
    }

    @Enumerated(EnumType.STRING)
    private DrugRelatedCrimeType type;
}
