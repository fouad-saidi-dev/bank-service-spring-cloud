package com.fouadev.beneficiaryservice.services.impl;

import com.fouadev.beneficiaryservice.dto.BeneficiaryDTO;
import com.fouadev.beneficiaryservice.entities.Beneficiary;
import com.fouadev.beneficiaryservice.mapper.BeneficiaryMapper;
import com.fouadev.beneficiaryservice.repositories.BeneficiaryRepository;
import com.fouadev.beneficiaryservice.services.BeneficiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class BeneficiaryServiceImpl implements BeneficiaryService {

    @Autowired
    private BeneficiaryRepository beneficiaryRepository;
    @Autowired
    private BeneficiaryMapper beneficiaryMapper;

    @Override
    public BeneficiaryDTO createBeneficiary(BeneficiaryDTO beneficiaryDTO) {
        Beneficiary beneficiary = Beneficiary.builder()
                .id(UUID.randomUUID().toString())
                .firstName(beneficiaryDTO.getFirstName())
                .lastName(beneficiaryDTO.getLastName())
                .rib(generateRib())
                .beneficiaryType(beneficiaryDTO.getBeneficiaryType())
                .build();

        Beneficiary savedBeneficiary = beneficiaryRepository.save(beneficiary);

        BeneficiaryDTO beneficiaryDTO1 = beneficiaryMapper.fromBeneficiary(savedBeneficiary);

        return beneficiaryDTO1;
    }

    @Override
    public BeneficiaryDTO getBeneficiary(String id) {
        Beneficiary beneficiary = beneficiaryRepository.findById(id).orElseThrow(() -> new RuntimeException("beneficiary not found"));

        BeneficiaryDTO beneficiaryDTO = beneficiaryMapper.fromBeneficiary(beneficiary);
        beneficiaryDTO.setId(id);

        return beneficiaryDTO;
    }

    @Override
    public BeneficiaryDTO updateBeneficiary(String id, BeneficiaryDTO beneficiaryDTO) {
        Beneficiary beneficiary = beneficiaryRepository.findById(id).orElseThrow(() -> new RuntimeException("beneficiary not found"));

        beneficiary.setFirstName(beneficiaryDTO.getFirstName());
        beneficiary.setLastName(beneficiaryDTO.getLastName());

        Beneficiary savedBeneficiary = beneficiaryRepository.save(beneficiary);
        BeneficiaryDTO beneficiaryDTO1 = beneficiaryMapper.fromBeneficiary(savedBeneficiary);

        return beneficiaryDTO1;
    }

    @Override
    public List<BeneficiaryDTO> getAllBeneficiaries() {

        List<BeneficiaryDTO> beneficiaryDTOS = new ArrayList<>();

        List<Beneficiary> beneficiaryList = beneficiaryRepository.findAll();

        for (Beneficiary beneficiary : beneficiaryList) {
            BeneficiaryDTO beneficiaryDTO = beneficiaryMapper.fromBeneficiary(beneficiary);
            beneficiaryDTOS.add(beneficiaryDTO);
        }

        return beneficiaryDTOS;
    }

    @Override
    public void deleteBeneficiary(String id) {
        beneficiaryRepository.deleteById(id);
    }

    @Override
    public String generateRib() {
        StringBuilder rib = new StringBuilder();
        for (int i = 0; i < 24; i++) {
            int digit = (int) (Math.random() * 10); // Random digit between 0-9
            rib.append(digit);
        }
        return rib.toString();
    }
}