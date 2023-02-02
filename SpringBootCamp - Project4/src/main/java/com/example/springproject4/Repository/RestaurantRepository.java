package com.example.springproject4.Repository;

import com.example.springproject4.Model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant,Integer> {
    List<Restaurant> findAllByBranchType(String branchType);

    Restaurant findRestaurantByBranchId( Integer id);
}