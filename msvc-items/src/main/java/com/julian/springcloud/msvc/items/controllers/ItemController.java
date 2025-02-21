package com.julian.springcloud.msvc.items.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.julian.springcloud.msvc.items.models.Item;
import com.julian.springcloud.msvc.items.services.ItemService;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class ItemController {
    private final ItemService service;

    public ItemController(ItemService service) {
        this.service = service;
    }

    @GetMapping
    public List<Item> list() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> detail(@PathVariable Long id) {
        Optional<Item> item = service.findById(id);
        if (item.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(item.get());
    }
}
