package com.example.springproject4.Controller;

import com.example.springproject4.Exception.ApiException;
import com.example.springproject4.Model.Restaurant;
import com.example.springproject4.Service.RestaurantService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/Restaurant")
public class RestaurantController {
    final private RestaurantService restaurantService;
    @GetMapping("/get")
    public ResponseEntity getUser(){
        List<Restaurant> restaurants = restaurantService.getRestaurant();
        return ResponseEntity.status(200).body(restaurants);
    }
    @PostMapping("/add")
    public ResponseEntity addRestaurant(@Valid @RequestBody Restaurant restaurant){

        restaurantService.addRestaurant(restaurant);
        return ResponseEntity.status(200).body("Restaurant Added");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@Valid @RequestBody Restaurant restaurant, @PathVariable Integer id) {

        boolean isValid = restaurantService.updateRestaurant(id,restaurant);
        if (isValid) {
            return ResponseEntity.status(200).body("Restaurant is updated ");
        }
        throw new ApiException("Id not Found");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteRestaurant(@PathVariable Integer id){
        boolean isValid = restaurantService.deleteRestaurant(id);
        if(isValid){
            return ResponseEntity.status(200).body("Restaurant is deleted ");
        }
        throw new ApiException("Id not Found");
    }
    @GetMapping("/getRestaurantByType/{branchType}")
    public ResponseEntity getRestaurantByBranchType(@PathVariable String branchType){
        List<Restaurant> restaurants=restaurantService.findAllByBranchType(branchType);
        return ResponseEntity.status(200).body(restaurants);
    }

}