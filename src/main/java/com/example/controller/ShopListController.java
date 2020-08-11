package com.example.controller;

import com.example.persist.ShopItem;
import com.example.persist.ShopItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ShopListController {

    private final ShopItemRepository repository;

    @Autowired
    public ShopListController(ShopItemRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public String indexPage(Model model){
        model.addAttribute("items",repository.findAll());
        model.addAttribute("item",new ShopItem());
        return "index";
    }

    @PostMapping
    public String newShopItems (ShopItem item){
        repository.save(item);
        return "redirect:/";
    }

    @DeleteMapping ("/{id}")
    public String deleteShopItem(@PathVariable("id") Long id){
        repository.deleteById(id);
        return "redirect:/";
    }
}
