package com.biziukov.task_1.controller;

import com.biziukov.task_1.domain.Item;
import com.biziukov.task_1.service.ItemService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
@Log
public class ItemController {

    private final ItemService itemService;

    @GetMapping
    public String getIndex() {
        //Эксперименты с логом
        log.info("Открыта главная страница");
        return "index";
    }

    @GetMapping("/items")
    public String getItems(Model model) {
        model.addAttribute("items", itemService.getItems());
        log.info("Открыта страница с содержимым");
        return "items";
    }

    @PostMapping("/items")
    public String addItem(Item item, Model model) {
        itemService.addItem(item);
        model.addAttribute("items", itemService.getItems());
        log.info("Add item: " + item);
        return "items";
    }
}