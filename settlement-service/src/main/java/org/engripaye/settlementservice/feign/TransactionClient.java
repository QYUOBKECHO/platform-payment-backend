package org.engripaye.settlementservice.feign;

import org.engripaye.settlementservice.dto.TransactionDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "transaction-service", url = "http://localhost:8080/api/transactions")
public interface TransactionClient {

    @GetMapping("/{id}")
    TransactionDTO getTransactionById(
            @PathVariable("id") Long id);
}
