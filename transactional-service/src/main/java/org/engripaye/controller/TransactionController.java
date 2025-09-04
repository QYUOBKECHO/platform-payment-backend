package org.engripaye.controller;

import lombok.RequiredArgsConstructor;
import org.engripaye.dto.TransactionDTO;
import org.engripaye.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @PostMapping("create")
    public ResponseEntity<TransactionDTO> createTransaction(@RequestBody TransactionDTO dto){
        return ResponseEntity.ok(transactionService.processTransaction(dto));
    }
}
