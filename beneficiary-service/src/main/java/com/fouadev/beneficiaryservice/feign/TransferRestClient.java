package com.fouadev.beneficiaryservice.feign;

import com.fouadev.beneficiaryservice.model.Transfer;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "transfer-service")
public interface TransferRestClient {

    @GetMapping("/api/transfers")
    @CircuitBreaker(name = "transferServiceCB",fallbackMethod = "getDefaultTransfer")
    PagedModel<Transfer> getAllTransfers();

    default PagedModel<Transfer> getDefaultTransfer(Exception e){
        return PagedModel.empty();
    }
}
