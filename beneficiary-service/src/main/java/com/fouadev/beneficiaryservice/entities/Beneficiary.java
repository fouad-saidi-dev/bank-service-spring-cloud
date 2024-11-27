package com.fouadev.beneficiaryservice.entities;

import com.fouadev.beneficiaryservice.model.Transfer;
import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

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
    @Transient
    private Collection<Transfer> transferList;
}