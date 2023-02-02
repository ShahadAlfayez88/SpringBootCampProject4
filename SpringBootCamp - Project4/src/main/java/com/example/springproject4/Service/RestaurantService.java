package com.example.springproject4.Service;

import com.example.springproject4.Exception.ApiException;
import com.example.springproject4.Model.Restaurant;
import com.example.springproject4.Repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;
    public List<Restaurant> getRestaurant() {
        return restaurantRepository.findAll();
    }
    public void addRestaurant(Restaurant restaurant) {
        restaurantRepository.save(restaurant);
    }
    public boolean updateRestaurant(Integer id, Restaurant restaurant) {
        Restaurant oldRestaurant = restaurantRepository.findRestaurantByBranchId(id);

        if (!restaurantRepository.existsById(id)) {
            return false;
        }
        oldRestaurant.setName(restaurant.getName());
        oldRestaurant.setBranchType(restaurant.getBranchType());
        oldRestaurant.setAddress(restaurant.getAddress());
        restaurantRepository.save(oldRestaurant);
        return true;
    }
    public boolean deleteRestaurant(Integer id) {
        Restaurant restaurant = restaurantRepository.findRestaurantByBranchId(id);
        if (!restaurantRepository.existsById(id)) {
            return false;
        }
        restaurantRepository.delete(restaurant);
        return true;
    }
    public List<Restaurant> findAllByBranchType(String branchType){
        List<Restaurant> restaurants=restaurantRepository.findAllByBranchType(branchType);
        if (restaurants.isEmpty()){
            throw new ApiException("there is no restaurant whiten this type");

        }
        return restaurants;
    }

}