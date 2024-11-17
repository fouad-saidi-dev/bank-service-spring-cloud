package com.fouadev.transferservice.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Beneficiary {
    private String id;
    private String firstName;
    private String lastName;
    private String rib;
    private String beneficiaryType;
}