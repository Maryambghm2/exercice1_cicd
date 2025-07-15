package org.example.exo2_spring_product.services;

import org.example.exo2_spring_product.models.Product;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class ProductService {

    private final Map<UUID, Product> products = new HashMap<>();


    public boolean create(String name, String category, double price) {
        Product newProduct = Product.builder().id(UUID.randomUUID()).name(name).category(category).price(price).build();
        products.put(newProduct.getId(), newProduct);
        return true;
    }

    public List<Product> getAllProducts() {
        return products.values().stream().toList();
    }

    public Product getById(UUID id) {
        return products.get(id);
    }

    public List<Product> getByCategorie(String categorie) {
        // Deux conditions en meme temps
//        return products.values().stream()
//                .filter(p -> p.getCategory().equals(categorie) && p.getPrice() <= price)
//        .toList();
        return products.values().stream()
                .filter(p -> p.getCategory().equals(categorie))
                .toList();
    }

    public List<Product> getByPriceMax(int priceMax) {
        return products.values().stream()
                .filter(p -> p.getPrice() <= priceMax)
                .toList();
    }


}
