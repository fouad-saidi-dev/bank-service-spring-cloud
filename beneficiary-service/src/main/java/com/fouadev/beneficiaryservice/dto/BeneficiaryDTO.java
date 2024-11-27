package com.fouadev.beneficiaryservice.dto;

import com.fouadev.beneficiaryservice.entities.BeneficiaryType;
import com.fouadev.beneficiaryservice.model.Transfer;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class BeneficiaryDTO {
    private String id;
    private String firstName;
    private String lastName;
    private String rib;
    private BeneficiaryType beneficiaryType;
    private List<Transfer> transferList;
}