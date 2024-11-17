package com.fouadev.beneficiaryservice.web;

import com.fouadev.beneficiaryservice.dto.BeneficiaryDTO;
import com.fouadev.beneficiaryservice.mapper.BeneficiaryMapper;
import com.fouadev.beneficiaryservice.services.BeneficiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apiRest/beneficiaries")
public class BeneficiaryRestController {
    @Autowired
    private BeneficiaryService beneficiaryService;
    @PostMapping("")
    public BeneficiaryDTO createBeneficiary(@RequestBody BeneficiaryDTO beneficiaryDTO) {
        return beneficiaryService.createBeneficiary(beneficiaryDTO);
    }
    @GetMapping("/{id}")
    public BeneficiaryDTO getBeneficiary(@PathVariable String id) {
        return beneficiaryService.getBeneficiary(id);
    }
    @GetMapping("")
    public List<BeneficiaryDTO> getAllBeneficiaries() {
        return beneficiaryService.getAllBeneficiaries();
    }
    @PutMapping("/{id}")
    public BeneficiaryDTO updateBeneficiary(@PathVariable String id, @RequestBody BeneficiaryDTO beneficiaryDTO) {
        return beneficiaryService.updateBeneficiary(id, beneficiaryDTO);
    }
    @DeleteMapping("/{id}")
    public void deleteBeneficiary(@PathVariable String id) {
        beneficiaryService.deleteBeneficiary(id);
    }
}