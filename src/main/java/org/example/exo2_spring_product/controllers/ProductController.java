package org.example.exo2_spring_product.controllers;

import org.example.exo2_spring_product.models.Product;
import org.example.exo2_spring_product.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

@Controller
public class ProductController {
        private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;

        // Création produits;
        productService.create("MacBook Pro", "Informatique", 2200.00);
        productService.create("iPhone 13", "Téléphonie", 999.99);
        productService.create("Clavier Logitech", "Informatique", 49.99);
        productService.create("Chaise Gaming", "Mobilier", 199.90);
        productService.create("Samsung Galaxy S22", "Téléphonie", 899.99);
        productService.create("Table de bureau", "Mobilier", 159.99);
        productService.create("Écran 4K", "Informatique", 349.99);
        productService.create("Aspirateur Dyson", "Électroménager", 449.00);
        productService.create("Lampe de chevet", "Mobilier", 29.99);
        productService.create("Casque Bluetooth", "Audio", 89.90);
    }


 @GetMapping("/products")
public String getProducts(Model model){
     List<Product> products = productService.getAllProducts();
     model.addAttribute("products", products);
     // Retourner la page html ou requiper l'attribut
     return "products";
 }

 @GetMapping("products/{id}")
    public String getProductById(@PathVariable UUID id, Model model) {
        Product product = productService.getById(id);
        model.addAttribute("product", product);
        return "product";
 }

}
