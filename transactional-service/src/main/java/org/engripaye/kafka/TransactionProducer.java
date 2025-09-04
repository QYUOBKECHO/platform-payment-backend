package org.engripaye.kafka;

import lombok.AllArgsConstructor;
import org.engripaye.dto.TransactionDTO;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TransactionProducer {

    private final KafkaTemplate<String, TransactionDTO> kafkaTemplate;

    public void sendTransaction(TransactionDTO dto){
        kafkaTemplate.send("transaction-topic", dto);
    }
}
