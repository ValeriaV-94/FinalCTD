package com.integrador.backend.services;

import com.integrador.backend.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Product saveProduct(Product product);
    List<Product> searchAllProducts();
    Optional<Product> searchProductById(Long id);
    Product updateProduct(Product product);
    void deleteProduct(Long id);
    List<Product> searchProductByCity(Long id);
    List<Product> searchProductByCategory(Long id);

}
