package com.example.springproject4.Controller;


import com.example.springproject4.Exception.ApiException;
import com.example.springproject4.Model.Menu;
import com.example.springproject4.Service.MenuService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/menu")
@RequiredArgsConstructor
public class MenuController {

    private final MenuService menuService;

    @GetMapping("/get")
    public ResponseEntity getMenu(){
        List<Menu> menus=menuService.getMenu();
        return ResponseEntity.status(200).body(menus);
    }

    @PostMapping("/add")
    public ResponseEntity addMenu(@Valid @RequestBody Menu menu){

        menuService.addMenu(menu);
        return ResponseEntity.status(200).body("Menu Added");
    }

    @PutMapping("/update/{itemID}")
    public ResponseEntity updateMenu(@PathVariable Integer itemID,@Valid@RequestBody Menu menu){
        boolean isUpdate= menuService.updateMenu(itemID, menu);
        if(isUpdate) {
            return ResponseEntity.status(200).body("Menu Updated");
        }
        throw new ApiException("Wrong item Id");
    }

    @DeleteMapping("/delete/{itemID}")
    public  ResponseEntity deleteDirector(@PathVariable Integer itemID){
        boolean isDelete= menuService.deleteMenu(itemID);
        if(isDelete) {
            return ResponseEntity.status(200).body("Menu Deleted");
        }
        throw new ApiException("wrong  item Id");
    }
    @GetMapping("/findtype/{itemID}")
    public ResponseEntity getitemType(@PathVariable Integer itemID){
        String menus=menuService.getItemType(itemID);
        return ResponseEntity.status(200).body(menus);
    }
    @GetMapping("/findprice/{itemName}")
    public ResponseEntity getitemPrice(@PathVariable String itemName){
        Integer menus=menuService.getItemPrice(itemName);
        return ResponseEntity.status(200).body(menus);
    }

    @GetMapping("/getmenu/{branchId}")
    public ResponseEntity getMenu(@PathVariable Integer branchId){
      List <Menu> m =  menuService.getBranchMenu(branchId);
        return ResponseEntity.status(200).body(m);
    }
}