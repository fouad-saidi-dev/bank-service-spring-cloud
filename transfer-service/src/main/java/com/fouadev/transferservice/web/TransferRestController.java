package com.fouadev.transferservice.web;

import com.fouadev.transferservice.entities.Transfer;
import com.fouadev.transferservice.feign.BeneficiaryRestClient;
import com.fouadev.transferservice.repositories.TransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/apiRest/transfers")
public class TransferRestController {

    @Autowired
    private TransferRepository transferRepository;
    @Autowired
    private BeneficiaryRestClient beneficiaryRestClient;

    @GetMapping("")
    public Iterable<Transfer> getAllTransfers() {
        Iterable<Transfer> transfers = transferRepository.findAll();
        transfers.forEach(transfer -> {
            transfer.setBeneficiary(beneficiaryRestClient.findById(transfer.getBeneficiaryId()));
        });
        return transfers;
    }
}