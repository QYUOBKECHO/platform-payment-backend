package org.engripaye.settlementservice.kafka;

import org.engripaye.settlementservice.dto.TransactionDTO;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class TransactionConsumer {

    @KafkaListener(topics = "transaction-topic", groupId = "settlement-group")
    public void consumeTransaction(TransactionDTO dto) {
        System.out.println("📥 Received transaction event from Kafka: "
                + dto.getReference() + " | Amount: " + dto.getAmount());
    }
}
