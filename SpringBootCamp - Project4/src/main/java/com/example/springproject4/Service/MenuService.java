package com.example.springproject4.Service;

import com.example.springproject4.Exception.ApiException;
import com.example.springproject4.Model.Customer;
import com.example.springproject4.Model.Menu;
import com.example.springproject4.Model.Orders;
import com.example.springproject4.Model.Restaurant;
import com.example.springproject4.Repository.MenuRepository;
import com.example.springproject4.Repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuService {

    private final MenuRepository menuRepository;
    private final RestaurantRepository restaurantRepository;

    public List<Menu> getMenu(){
        return menuRepository.findAll();
    }


    public void addMenu(Menu menu){
        menuRepository.save(menu);
    }


    public boolean updateMenu(Integer itemID,Menu menu){
        Menu oldMenu=menuRepository.findMenuByItemID(itemID);
        if(oldMenu==null){
            return false;
        }


        oldMenu.setItemName(menu.getItemName());
        oldMenu.setItemType(menu.getItemType());
        oldMenu.setItemPrice(menu.getItemPrice());
        oldMenu.setItemDescription(menu.getItemDescription());
        oldMenu.setBranchID(menu.getBranchID());
        menuRepository.save(oldMenu);
        return true;
    }

    public boolean deleteMenu(Integer itemID){
        Menu menu =menuRepository.findMenuByItemID(itemID);
        if(menu==null){
            return false;
        }
        menuRepository.delete(menu);
        return true;
    }

    public String getItemType(Integer itemID){
        Menu menu =menuRepository.findMenuByItemID(itemID);
        if(menu==null){
            throw  new ApiException("item id not found");
        }

        return menu.getItemType();
    }

    public Integer getItemPrice(String itemName){
        Menu menu =menuRepository.findMenuByItemName(itemName);
        if(menu==null){
            throw  new ApiException("item name not found");
        }

        return menu.getItemPrice();
    }

    public List getBranchMenu(Integer id){
        // هنا جبنا المطعم
        Restaurant restaurant = restaurantRepository.findRestaurantByBranchId(id);
        // يشيك على العميل
        if(restaurant==null){
            throw new ApiException("id not found");
        }

        // هنا نجيب المنيو
        List<Menu> menu = menuRepository.findAllByBranchID(id);
        // يشيك على الطلب
        if(menu==null){
            throw new ApiException("Menu is not found");
        }

        return menu;
    }
}
