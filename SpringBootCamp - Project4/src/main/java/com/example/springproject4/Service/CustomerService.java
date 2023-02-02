package com.example.springproject4.Service;
import com.example.springproject4.Exception.ApiException;
import com.example.springproject4.Model.Customer;
import com.example.springproject4.Model.Orders;
import com.example.springproject4.Repository.CustomerRepository;
import com.example.springproject4.Repository.OrdersRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class CustomerService {

    private CustomerRepository customerRepository;
    private OrdersRepository ordersRepository;
    public CustomerService(CustomerRepository customerRepository, OrdersRepository ordersRepository){
        this.customerRepository=customerRepository;
        this.ordersRepository=ordersRepository;
    }

    // Display
    public List findAllcustomer(){
        return customerRepository.findAll();
    }

    //Add
    public void AddCustomer(Customer customer){
        customerRepository.save(customer);
    }

    // Update
    public void UpdateCustomer(Integer id,Customer customer){
        Customer OldCustomer = customerRepository.findCustomerById(id);
        if(OldCustomer==null){
            throw new ApiException("wrong id");
        }
        OldCustomer.setAddress(customer.getAddress());
        OldCustomer.setBalance(customer.getBalance());
        OldCustomer.setName(customer.getName());
        OldCustomer.setOrderid(customer.getOrderid());
        OldCustomer.setNoOfOrders(customer.getNoOfOrders());
        customerRepository.save(OldCustomer);
    }

    //Delete
    public void  DeleteCustomer(Integer id){
        Customer deletecustomer = customerRepository.findCustomerById(id);
        if(deletecustomer==null){
            throw new ApiException("wrong id");
        }
        customerRepository.delete(deletecustomer);
    }

    // Pay Order

    public int buyorder(Integer id){
        // هنا جبنا الكوستمر
        Customer customer =customerRepository.findCustomerById(id);

        // يشيك على العميل
        if(customer==null){
            throw new ApiException("id not found");
        }
        int ordernumber = customer.getOrderid();
        System.out.println(ordernumber);

        // هنا نجيب طلبه
        Orders orders = ordersRepository.findOrdersByOrderId(ordernumber);
        // يشيك على الطلب
        if(orders==null){
            throw new ApiException("order not found");
        }
        if(orders.getOrderPrice()>customer.getBalance()){
            String status = "rejected";
            orders.setOrderStatus(status);
            ordersRepository.save(orders);
            throw new ApiException("the order price is higher than balance");
        }
        int total= customer.getBalance()-orders.getOrderPrice();
        int count = 1 ;
        int noOfOrder = orders.getOrderId();
        customer.setBalance(total);
        customer.setNoOfOrders(noOfOrder+1);
        customerRepository.save(customer);
        return customer.getBalance();
    }

    // get balance
    public int getBalance(Integer id){
        Customer customer =customerRepository.findCustomerById(id);
        if(customer==null){
            throw new ApiException("wrong id");
        }
        return customer.getBalance();
    }

    //
    public int checkpayemenmethod(Integer id) {
        // هنا جبنا الكوستمر
        Customer customer = customerRepository.findCustomerById(id);

        // يشيك على العميل
        if (customer == null) {
            throw new ApiException("id not found");
        }
        int ordernumber = customer.getOrderid();

        // هنا نجيب طلبه
        Orders orders = ordersRepository.findOrdersByOrderId(ordernumber);
        // يشيك على الطلب
        if (orders == null) {
            throw new ApiException("order not found");
        }
        if (orders.getPaymentMethod().equals("Card")) {
            int tax = 15;
            int all = orders.getOrderPrice() + tax;
            orders.setOrderPrice(all);
            ordersRepository.save(orders);
            customerRepository.save(customer);
        }
        return orders.getOrderPrice();
    }
}