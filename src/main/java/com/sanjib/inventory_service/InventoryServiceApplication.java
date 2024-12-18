package com.sanjib.inventory_service;

import com.sanjib.inventory_service.entity.Product;
import com.sanjib.inventory_service.repository.ProductRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class InventoryServiceApplication {

//	@Autowired
//	private ProductRepository repository;
//
//	@PostConstruct
//	public void initDB(){
//		List<Product> products = Stream.of(
//				new Product("Laptop", "Electronics", 74999.99f, 50),
//				new Product("SmartPhone", "Electronics", 39999.99f, 40),
//				new Product("Office Chair", "Furniture", 74999.99f, 30),
//				new Product("NoteBook", "Stationery", 74999.99f, 80),
//				new Product("Desk Lamp", "Furniture", 74999.99f, 47),
//				new Product("Water Bottle", "Accessories", 74999.99f, 48)
//		).collect(Collectors.toList());
//
//		repository.saveAll(products);
//	}

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

}
