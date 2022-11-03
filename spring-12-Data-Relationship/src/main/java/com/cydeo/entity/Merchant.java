package com.cydeo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


@Data
@NoArgsConstructor
@Table(name="merchants")
@Entity
public class Merchant {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id ;

    private String name;
    private String code;
    private BigDecimal transactionFee;
    private BigDecimal commissionRate;
    private Integer payoutDelayCount;

//any merchant object has payment one seller has multiple payments (list of payment )


   // @OneToMany(mappedBy="merchant")//in one to many relationship ownership belongs to many side
   // private List<Payment> paymentList;


    public Merchant(String name, String code, BigDecimal transactionFee, BigDecimal commissionRate, Integer payoutDelayCount) {
        this.name = name;
        this.code = code;
        this.transactionFee = transactionFee;
        this.commissionRate = commissionRate;
        this.payoutDelayCount = payoutDelayCount;
    }
}
