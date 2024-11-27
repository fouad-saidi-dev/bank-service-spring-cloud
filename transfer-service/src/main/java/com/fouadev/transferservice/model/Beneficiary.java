package com.fouadev.transferservice.model;


import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Beneficiary {
    private String id;
    private String firstName;
    private String lastName;
    private String rib;
    private String beneficiaryType;
}