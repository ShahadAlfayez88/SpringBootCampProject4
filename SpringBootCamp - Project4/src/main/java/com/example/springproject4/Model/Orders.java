package com.example.springproject4.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orders {

    @Id
    @NotNull(message ="ID field is required" )
    private int orderId ;

//    @NotNull(message ="Customer ID field is required" )
//    private int CustomerId ;
    @NotNull(message ="Order Price field is required" )
    @Min(value = 1)
    private int orderPrice;

    @NotEmpty(message ="Order Date field is required" )
    private String orderDate;

    @NotEmpty(message = "order type field is required")
    @Pattern( regexp = "^dineIn|pickup$" ,message = "order field only allow input: dine In or pickup" )
    private String orderType;
    @NotEmpty(message ="Order status field is required" )
    @Pattern( regexp = "^onProgress|finished|started|rejected$" ,message = "Order Status field only allow input: onProgress,finished,Started,Rejected" )
    private String orderStatus;

    @NotEmpty(message ="Payment Method field is required" )
    @Pattern( regexp = "^Cash|Card$" ,message = "Payment method field only allow input: Cash, Card" )
    private String paymentMethod;

}
