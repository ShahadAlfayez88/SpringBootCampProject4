package com.example.springproject4.Controller;

import com.example.springproject4.Model.Customer;
import com.example.springproject4.Service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService){
        this.customerService=customerService;
    }

    // Display

    @GetMapping("/getcustomer")
    public ResponseEntity GetAllCustomer(){
        List<Customer>customers=customerService.findAllcustomer();
        return ResponseEntity.status(200).body(customers);
    }

    // Add
    @PostMapping("/add")
    public ResponseEntity AddCustomer(@Valid @RequestBody Customer customer){
        customerService.AddCustomer(customer);
        return ResponseEntity.status(200).body("customer added");
    }

    //Update

    @PutMapping("/update/{id}")
    public ResponseEntity UpdateCustomer(@PathVariable Integer id , @Valid @RequestBody Customer customer){
        customerService.UpdateCustomer(id,customer);
        return ResponseEntity.status(200).body("customer updated");
    }

    //Delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity DeleteCustomer(@PathVariable Integer id){
        customerService.DeleteCustomer(id);
        return ResponseEntity.status(200).body("customer deleted");
    }

    // Pay Order
    @GetMapping("/buy/{id}")
    public ResponseEntity BuyOrder(@PathVariable Integer id){
        return ResponseEntity.status(200).body("Thank you for your purchase, your new balance is : "+customerService.buyorder(id));
    }

    // Get balance

    @GetMapping("/balance/{id}")
    public ResponseEntity GetBlance(@PathVariable Integer id){
        return ResponseEntity.status(200).body(customerService.getBalance(id));

    }

    @GetMapping("/check/{id}")
    public ResponseEntity checkPayement(@PathVariable Integer id ){
        return ResponseEntity.status(200).body("You will pay :"+customerService.checkpayemenmethod(id));

    }
}