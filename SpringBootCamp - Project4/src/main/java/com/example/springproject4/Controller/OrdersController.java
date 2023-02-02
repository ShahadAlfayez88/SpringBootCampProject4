package com.example.springproject4.Controller;

import com.example.springproject4.Model.Orders;
import com.example.springproject4.Service.OrdersService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order")
@RequiredArgsConstructor
public class OrdersController {

    final private OrdersService orderzervice;

    //display
    @GetMapping("/display")
    public ResponseEntity getAllOrders(){
        List<Orders> movies = orderzervice.getAllOrders();
        return ResponseEntity.status(200).body(movies);
    }

    //Add
    @PostMapping("/add")
    public ResponseEntity addNewOrders(@Valid @RequestBody Orders movie){
        orderzervice.addNewOrders(movie);
        return ResponseEntity.status(200).body("order Added");
    }

    //update
    @PutMapping("/update/{id}")
    public ResponseEntity updateThisOrders(@Valid @RequestBody Orders movie, @PathVariable Integer id) {

        orderzervice.updateThisOrder(id,movie);
        return ResponseEntity.status(200).body("order is updated ");
    }

    //delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteThisOrder(@PathVariable Integer id){
        orderzervice.deleteThisOrder(id);
        return ResponseEntity.status(200).body("order is deleted ");
    }

    //     get all orders with specific status

    @GetMapping("/getOrderByStatus/{status}")
    public ResponseEntity findallorders(@PathVariable String status) {

        List<Orders> orders =orderzervice.findAllByStatus(status);
        return ResponseEntity.status(200).body(orders);
    }



}
