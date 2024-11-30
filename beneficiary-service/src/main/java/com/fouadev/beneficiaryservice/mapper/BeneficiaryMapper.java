package com.fouadev.beneficiaryservice.mapper;

import com.fouadev.beneficiaryservice.dto.BeneficiaryDTO;
import com.fouadev.beneficiaryservice.entities.Beneficiary;
import com.fouadev.beneficiaryservice.model.Transfer;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BeneficiaryMapper {
    public BeneficiaryDTO fromBeneficiary(Beneficiary beneficiary) {

        BeneficiaryDTO beneficiaryDTO = new BeneficiaryDTO();

        BeanUtils.copyProperties(beneficiary, beneficiaryDTO);

        if (beneficiary.getTransferList() != null) {
            beneficiaryDTO.setTransferList((List<Transfer>) beneficiary.getTransferList()); // Use the same list
        } else {
            beneficiaryDTO.setTransferList(new ArrayList<>());
        }

        return beneficiaryDTO;
    }

    public Beneficiary toBeneficiary(BeneficiaryDTO beneficiaryDTO) {

        Beneficiary beneficiary = new Beneficiary();

        BeanUtils.copyProperties(beneficiaryDTO, beneficiary);

        return beneficiary;
    }
}