package com.fouadev.transferservice.feign;

import com.fouadev.transferservice.model.Beneficiary;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "beneficiary-service")
public interface BeneficiaryRestClient {
    @GetMapping("/api/beneficiaries/{id}")
    Beneficiary findById(@PathVariable String id);
    @GetMapping("/api/beneficiaries")
    PagedModel<Beneficiary> findAll();
}
