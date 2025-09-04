package org.engripaye.service;

import lombok.AllArgsConstructor;
import org.engripaye.dto.TransactionDTO;
import org.engripaye.model.Transaction;
import org.engripaye.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@AllArgsConstructor
public class TransactionService {

    private final TransactionRepository repository;


    public TransactionDTO processTransaction(TransactionDTO dto) {
        // Create new Transaction entity
        Transaction transaction = new Transaction();
        transaction.setReference(UUID.randomUUID().toString()); // Generate unique reference
        transaction.setAmount(dto.getAmount());
        transaction.setStatus("PENDING");
        transaction.setCreatedAt(LocalDateTime.now());

        // Save to DB
        Transaction saved = repository.save(transaction);

        // Map entity back to DTO
        return new TransactionDTO(
                saved.getId(),
                saved.getReference(),
                saved.getAmount(),
                saved.getStatus(),
                saved.getCreatedAt()
        );
    }

    public TransactionDTO findById(Long id) {
        return repository.findById(id)
                .map(tx -> new TransactionDTO(
                        tx.getId(),
                        tx.getReference(),
                        tx.getAmount(),
                        tx.getStatus(),
                        tx.getCreatedAt()
                ))
                .orElseThrow(() -> new RuntimeException("Transaction not found with id " + id));
    }
}
