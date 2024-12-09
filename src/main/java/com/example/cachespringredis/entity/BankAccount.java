package com.example.cachespringredis.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Embeddable
public class BankAccount implements Serializable {

    @Column(name = "score_number")
    private Long scoreNumber;
    @Column
    private BigDecimal funds;
    @Column
    private Boolean active = true;
}
