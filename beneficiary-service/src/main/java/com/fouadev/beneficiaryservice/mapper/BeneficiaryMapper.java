package com.fouadev.beneficiaryservice.mapper;

import com.fouadev.beneficiaryservice.dto.BeneficiaryDTO;
import com.fouadev.beneficiaryservice.entities.Beneficiary;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class BeneficiaryMapper {
    public BeneficiaryDTO fromBeneficiary(Beneficiary beneficiary) {

        BeneficiaryDTO beneficiaryDTO = new BeneficiaryDTO();

        BeanUtils.copyProperties(beneficiary, beneficiaryDTO);

        return beneficiaryDTO;
    }

    public Beneficiary toBeneficiary(BeneficiaryDTO beneficiaryDTO) {

        Beneficiary beneficiary = new Beneficiary();

        BeanUtils.copyProperties(beneficiaryDTO, beneficiary);

        return beneficiary;
    }
}