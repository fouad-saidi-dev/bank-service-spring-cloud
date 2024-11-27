package com.fouadev.beneficiaryservice;

import com.fouadev.beneficiaryservice.entities.Beneficiary;
import com.fouadev.beneficiaryservice.entities.BeneficiaryType;
import com.fouadev.beneficiaryservice.feign.TransferRestClient;
import com.fouadev.beneficiaryservice.model.Transfer;
import com.fouadev.beneficiaryservice.repositories.BeneficiaryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Collection;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
@EnableFeignClients
public class BeneficiaryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BeneficiaryServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner init(BeneficiaryRepository beneficiaryRepository,
						   TransferRestClient transferRestClient){
		return args -> {
			Collection<Transfer> transfers = transferRestClient.getAllTransfers().getContent();
			Stream.of("fouad","reda","mohamed","imane","ahmed").forEach( name -> {
				Beneficiary beneficiary = Beneficiary.builder()
						.id(UUID.randomUUID().toString())
						.firstName(name)
						.lastName(name+" last")
						.rib(generateRib())
						.beneficiaryType(BeneficiaryType.PHYSIQUE)
						.transferList(transfers.stream().toList())
						.build();
				beneficiaryRepository.save(beneficiary);

				System.out.println("**************************");
				System.out.println("added "+beneficiary);
			});


		};
	}

	private static String generateRib() {
		// Generate a 24-digit RIB as a string
		StringBuilder rib = new StringBuilder();
		for (int i = 0; i < 24; i++) {
			int digit = (int) (Math.random() * 10); // Random digit between 0-9
			rib.append(digit);
		}
		return rib.toString();
	}


}
