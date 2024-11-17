package com.fouadev.transferservice.entities;

import com.fouadev.transferservice.enums.TransferType;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString
public class Transfer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String beneficiaryId;
    private String sourceRib;
    private Double amount;
    private String description;
    private Date date;
    @Enumerated(value = EnumType.STRING)
    private TransferType type;


}