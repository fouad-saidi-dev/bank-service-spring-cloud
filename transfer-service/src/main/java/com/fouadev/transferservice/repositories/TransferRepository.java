package com.fouadev.transferservice.repositories;

import com.fouadev.transferservice.entities.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "transfers")
public interface TransferRepository extends JpaRepository<Transfer, Long> {
}
