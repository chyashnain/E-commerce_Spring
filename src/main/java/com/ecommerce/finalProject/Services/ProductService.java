package com.ecommerce.finalProject.Services;

import org.springframework.data.repository.CrudRepository;

import com.ecommerce.finalProject.Entities.Product;

public interface ProductService extends CrudRepository<Product, Long> {

}
