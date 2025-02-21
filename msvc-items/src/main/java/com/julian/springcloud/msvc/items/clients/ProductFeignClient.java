package com.julian.springcloud.msvc.items.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.julian.springcloud.msvc.items.models.Product;

@FeignClient(url = "http://localhost:8001", name = "msvc-products")
public interface ProductFeignClient {
    @GetMapping
    public List<Product> findAll();

    @GetMapping("/{id}")
    public ResponseEntity<Product> details(@PathVariable Long id);
}
