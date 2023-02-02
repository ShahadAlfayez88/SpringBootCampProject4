package com.example.springproject4.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Restaurant {
    @Id
    @NotNull(message = "id cannot be empty")
    private Integer branchId;
    @NotEmpty(message = " Name cannot be empty")
    @Size(min = 3,message = "name must be longer thant 3")
    private String name;
    @NotEmpty(message = "Branch Type cannot be empty")
    private String branchType;
    @NotEmpty(message = "Branch Type cannot be empty")
    @Size(min = 10,message = "address should include neighborhood name/ street name/ house number" )
    private String address;

}