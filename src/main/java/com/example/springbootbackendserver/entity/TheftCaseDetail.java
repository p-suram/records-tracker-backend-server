package com.example.springbootbackendserver.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class TheftCaseDetail extends CaseDetail {
    public enum TheftType {
        ROBBERY,  // theft involving force or threat of force
        SHOPLIFTING
    }

    @Enumerated(EnumType.STRING)
    @Column(length = 15)
    private TheftType type;
}
