package com.example.springproject4.Model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Menu {
    @Id
    @Column(columnDefinition = "int not null")
    @NotNull(message = "id should not be empty")
    private Integer itemID;

    @Column(columnDefinition = "VARCHAR(10) not null")
    @NotEmpty(message = "Item name should not be empty")
    @Size(min = 4, max = 10, message = "Item name should not be less than 4 and not more 10")
    private String itemName;

    @Column(columnDefinition = "VARCHAR(15) not null")
    @NotEmpty(message = "Item name should not be empty")
    @Size(min = 4, max = 15, message = "Item type should not be less than 4 and not more 15")
    private String itemType;

    @NotNull(message = "item price should not be empty")
    @Column(columnDefinition = "int not null")
    private Integer itemPrice;

    @Column(columnDefinition = "VARCHAR(30) not null")
    @NotEmpty(message = "Item description  should not be empty")
    @Size(min = 4, max = 30, message = "Item description should not be less than 4 and not more 30")
    private String itemDescription;

    @Column(columnDefinition = "int not null")
    @NotNull(message = "branch id should not be empty")
    private Integer branchID;

}