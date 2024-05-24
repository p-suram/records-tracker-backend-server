package com.example.springbootbackendserver.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class HomicideCaseDetail extends CaseDetail{
    public enum HomicideType {
        MURDER,
        MAN_SLAUGHTER
    }

    @Enumerated(EnumType.STRING)
    @Column(length = 15)
    private HomicideType type;
}
