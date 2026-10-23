package com.example.spring_boot.controller;


import com.example.spring_boot.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class productcontroller {

    private final ProductService productService;

    public productcontroller(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public String getProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "products";
    }
}