package org.engripaye.settlementservice.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDTO {

    private Long id;
    private String reference;
    private Double amount;
    private String status;
    private LocalDateTime createdAt;
}
