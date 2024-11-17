package com.fouadev.beneficiaryservice.repositories;

import com.fouadev.beneficiaryservice.entities.Beneficiary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "beneficiaries")
public interface BeneficiaryRepository extends JpaRepository<Beneficiary, String> {
}
