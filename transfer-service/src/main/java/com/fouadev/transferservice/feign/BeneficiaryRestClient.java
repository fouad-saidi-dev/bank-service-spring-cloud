package com.fouadev.transferservice.feign;

import com.fouadev.transferservice.model.Beneficiary;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "beneficiary-service")
public interface BeneficiaryRestClient {
    @GetMapping("/api/beneficiaries/{id}")
    @CircuitBreaker(name = "beneficiaryServiceCB",fallbackMethod = "getDefaultBeneficiary")
    Beneficiary findById(@PathVariable String id);
    @GetMapping("/api/beneficiaries")
    @CircuitBreaker(name = "beneficiaryServiceCB",fallbackMethod = "getDefaultAllBeneficiaries")
    PagedModel<Beneficiary> findAll();

    default Beneficiary getDefaultBeneficiary(String id,Exception e) {
        return Beneficiary.builder()
                .id(id)
                .rib("Default rib")
                .firstName("Default FirstName")
                .lastName("Default LastName")
                .beneficiaryType("Default Type")
                .build();
    }

    default PagedModel<Beneficiary> getDefaultAllBeneficiaries(Exception e) {
        return PagedModel.empty();
    }

}
