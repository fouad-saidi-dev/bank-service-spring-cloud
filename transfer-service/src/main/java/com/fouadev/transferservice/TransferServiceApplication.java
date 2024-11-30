package com.fouadev.transferservice;

import com.fouadev.transferservice.entities.Transfer;
import com.fouadev.transferservice.enums.TransferType;
import com.fouadev.transferservice.feign.BeneficiaryRestClient;
import com.fouadev.transferservice.model.Beneficiary;
import com.fouadev.transferservice.repositories.TransferRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Collection;
import java.util.Date;

@SpringBootApplication
@EnableFeignClients
public class TransferServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransferServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(TransferRepository transferRepository,
							BeneficiaryRestClient beneficiaryRestClient) {
		return args -> {
			Collection<Beneficiary> beneficiaries = beneficiaryRestClient.findAll().getContent();

			beneficiaries.forEach(beneficiary -> {

				Beneficiary beneficiary1 = beneficiaryRestClient.findById(beneficiary.getId());;

				System.out.println("**************************");
				System.out.println(beneficiary1.getFirstName());

				Transfer transfer = Transfer.builder()
						.beneficiaryId(beneficiary.getId())
						.type(TransferType.NORMAL)
						.amount(Math.random() * 1000)
						.sourceRib(beneficiary.getRib())
						.date(new Date())
						.description("normal transfer")
						.beneficiary(beneficiary1)
						.build();

				transferRepository.save(transfer);
			});
		};
	}
}
