package com.fouadev.beneficiaryservice.model;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Transfer {
    private Long id;
    private String beneficiaryId;
    private String sourceRib;
    private Double amount;
    private String description;
    private Date date;
    private String type;
}