package com.example.springproject4.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Customer {
    @Id
    @NotNull(message = "the name should be not null!")
    @Max(value = 3)
    private Integer id;


    @NotEmpty(message = "the name should be not null!")
    @Size(min = 3, message = "length more than 4")
    @Column(columnDefinition = "varchar(20) not null unique")
    private String name;


    @NotNull(message = "balance should  be not null")
    @Positive(message = "must be a positive balance")
    @Column(columnDefinition = "int not null check (balance>0)")
    private int balance;

    @NotNull(message = "NoOfOrders should  be not null")
    private int noOfOrders;

    @NotEmpty(message = "the adress should be not null!")
    @Size(min = 3, message = "length more than 4")
    @Column(columnDefinition = "varchar(10) not null ")
    private String address;

    private int orderid;
}
