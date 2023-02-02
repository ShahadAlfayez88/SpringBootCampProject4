package com.example.springproject4.Repository;

import com.example.springproject4.Model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer> {


    Orders findOrdersByOrderId(Integer OrderId);

    List<Orders> findAllByOrderStatus(String orderStatus);




}
