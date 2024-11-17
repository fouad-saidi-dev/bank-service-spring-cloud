package com.fouadev.beneficiaryservice.dto;

import com.fouadev.beneficiaryservice.entities.BeneficiaryType;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class BeneficiaryDTO {
    private String id;
    private String firstName;
    private String lastName;
    private String rib;
    private BeneficiaryType beneficiaryType;
}