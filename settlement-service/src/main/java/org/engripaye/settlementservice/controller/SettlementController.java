package org.engripaye.settlementservice.controller;

import lombok.RequiredArgsConstructor;
import org.engripaye.settlementservice.service.SettlementService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/settlements")
@RequiredArgsConstructor
public class SettlementController {

    private final SettlementService settlementService;

    @PostMapping("/{transactionId}")
    public ResponseEntity<String> settleTransaction(@PathVariable Long transactionId) {
        settlementService.settleTransaction(transactionId);
        return ResponseEntity.ok("Settlement initiated for transaction: " + transactionId);
    }
}
