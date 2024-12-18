package com.sanjib.inventory_service.service;

import com.sanjib.inventory_service.entity.Product;
import com.sanjib.inventory_service.repository.ProductRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {


    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> getProducts() {
        List<Product> products = repository.findAll();
        System.out.println("Products from DB: " + products); // Debug log
        return products;
    }


    public List<Product> getProductsByCategory(String category) {
        List<Product> products = repository.findByCategory(category);
        if (products.isEmpty())
            throw new RuntimeException("No products found for category: " + category); // Optional: Replace with a custom exception
        return products;
    }

    //sales team : update the stock of a product in (IS)
    public Product updateStock(int id, int stock){
        Product existingProduct = repository.findById(id).orElseThrow(
                ()-> new RuntimeException("Product not found with id " +id));
        existingProduct.setStock(stock);
        return repository.save(existingProduct);

    }

    //Warehouse : receive new shipment
    public Product receiveNewShipment(int id, int quantity){
        Product existingProduct = repository.findById(id).orElseThrow(
                ()-> new RuntimeException("Product not found with id " +id));
        existingProduct.setStock(existingProduct.getStock()+quantity);
        return repository.save(existingProduct);

    }
}
