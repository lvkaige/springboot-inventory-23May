package com.kaigelyu.chatgptinventoryhtml.controller;

import com.kaigelyu.chatgptinventoryhtml.model.Item;
import com.kaigelyu.chatgptinventoryhtml.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class InventoryController {

    @Autowired
    private ItemRepository itemRepository;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("items", itemRepository.findAll());
        return "index";
    }

    @PostMapping("/add")
    public String addItem(@RequestParam String name, @RequestParam Integer quantity) {
        Item item = new Item();
        item.setName(name);
        item.setQuantity(quantity);
        itemRepository.save(item);
        return "redirect:/";
    }
}