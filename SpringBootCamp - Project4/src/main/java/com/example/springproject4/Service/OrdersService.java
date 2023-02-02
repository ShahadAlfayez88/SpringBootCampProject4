package com.example.springproject4.Service;

import com.example.springproject4.Exception.ApiException;
import com.example.springproject4.Model.Orders;
import com.example.springproject4.Repository.OrdersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrdersService {
    final private OrdersRepository ordersRepository;

    // CRUD

    //ADD
    public void addNewOrders(Orders orders) {
        ordersRepository.save(orders);
    }

//    //DISPLAY
    public List<Orders> getAllOrders() {
        return ordersRepository.findAll();
    }

    //UPDATE
    public void updateThisOrder(Integer id, Orders orders) {
        Orders Oldmovie = ordersRepository.findOrdersByOrderId(id);

        if (Oldmovie == null) {
            throw new ApiException("order not found!!");
        }

        ordersRepository.save(Oldmovie);
    }

    //DELETE
    public void deleteThisOrder(Integer id) {
        Orders currentMovie = ordersRepository.findOrdersByOrderId(id);
        if (!ordersRepository.existsById(id)) {
            throw new ApiException("Id is not found");
        }
        ordersRepository.delete(currentMovie);
    }


//     get all order with specific status

    public List<Orders> findAllByStatus(String status){
        List<Orders> orders = ordersRepository.findAllByOrderStatus(status);
        if (orders.isEmpty()){
            throw new ApiException("there is no orders under this status");
        }
        return orders;
    }

}
