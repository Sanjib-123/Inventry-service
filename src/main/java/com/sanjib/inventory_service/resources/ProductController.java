package com.sanjib.inventory_service.resources;

import com.sanjib.inventory_service.entity.Product;
import com.sanjib.inventory_service.service.ProductService;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.ArrayList;
import java.util.List;

//@RestController
//@RequestMapping("/products")
@Controller
public class ProductController {


    private ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }


    //@GetMapping
    @QueryMapping
    public List<Product> getProducts() {
        List<Product> products = service.getProducts();
        return products != null ? products : new ArrayList<>();
    }



    //@GetMapping("/{category}") @PathVariable
    @QueryMapping
    public List<Product> getProductsByCategory(@Argument String category) {
        List<Product> products = service.getProductsByCategory(category.trim());
        return products != null ? products : new ArrayList<>();
    }

    @MutationMapping
    public Product updateStock(@Argument int id,@Argument int stock){
         return service.updateStock(id, stock);
    }


    @MutationMapping
    public Product receiveNewShipment(@Argument int id,@Argument int quantity){
        return service.receiveNewShipment(id, quantity);
    }
}
