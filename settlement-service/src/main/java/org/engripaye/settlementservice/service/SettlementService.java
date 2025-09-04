package org.engripaye.settlementservice.service;

import lombok.RequiredArgsConstructor;
import org.engripaye.settlementservice.dto.TransactionDTO;
import org.engripaye.settlementservice.feign.TransactionClient;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SettlementService {

    private final TransactionClient transactionClient;

    public void settleTransaction(Long transactionId) {
        // Fetch transaction from transaction-service via Feign
        TransactionDTO transaction = transactionClient.getTransactionById(transactionId);

        // Simulate settlement logic
        System.out.println("Settling transaction: " + transaction.getReference() +
                " | Amount: " + transaction.getAmount());

    }

}
