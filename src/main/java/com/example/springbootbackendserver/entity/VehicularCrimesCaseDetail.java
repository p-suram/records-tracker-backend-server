package com.example.springbootbackendserver.entity;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;


@Embeddable
@Getter
@Setter
public class VehicularCrimesCaseDetail extends CaseDetail {
    public enum VehicularCrimeType {
        HIT_AND_RUN,
        DRIVING_UNDER_THE_INFLUENCE,
        RECKLESS_DRIVING
    }

    @Enumerated(EnumType.STRING)
    private VehicularCrimeType type;
}
