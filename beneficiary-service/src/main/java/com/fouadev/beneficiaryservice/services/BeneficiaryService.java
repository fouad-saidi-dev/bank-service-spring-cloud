package com.fouadev.beneficiaryservice.services;

import com.fouadev.beneficiaryservice.dto.BeneficiaryDTO;

import java.util.List;

public interface BeneficiaryService {
    BeneficiaryDTO createBeneficiary(BeneficiaryDTO beneficiaryDTO);

    BeneficiaryDTO getBeneficiary(String id);

    BeneficiaryDTO updateBeneficiary(String id, BeneficiaryDTO beneficiaryDTO);
    List<BeneficiaryDTO> getAllBeneficiaries();

    void deleteBeneficiary(String id);
    String generateRib();


}
