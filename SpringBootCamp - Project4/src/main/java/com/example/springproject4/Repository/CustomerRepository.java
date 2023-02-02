package com.example.springproject4.Repository;




import com.example.springproject4.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    Customer findCustomerByName(String name);
    Customer findCustomerById(Integer id);
    Customer findCustomerByBalance(int balance);


}