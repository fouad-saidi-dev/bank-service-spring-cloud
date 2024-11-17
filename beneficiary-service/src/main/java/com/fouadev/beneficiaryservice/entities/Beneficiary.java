package com.fouadev.beneficiaryservice.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Beneficiary {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String rib;
    @Enumerated(value = EnumType.STRING)
    private BeneficiaryType beneficiaryType;
}