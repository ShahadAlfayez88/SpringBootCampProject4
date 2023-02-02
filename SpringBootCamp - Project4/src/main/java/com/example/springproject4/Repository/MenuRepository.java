package com.example.springproject4.Repository;


import com.example.springproject4.Model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepository extends JpaRepository<Menu,Integer> {

    Menu findMenuByItemID(Integer id);

    Menu findMenuByItemName(String string);

    List<Menu> findAllByBranchID(Integer BranchID);
}