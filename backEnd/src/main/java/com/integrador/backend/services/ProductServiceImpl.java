package com.integrador.backend.services;

import com.integrador.backend.model.Product;
import com.integrador.backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;
    final static Logger logger = Logger.getLogger(ProductServiceImpl.class.getName());


    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> searchAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> searchProductById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> searchProductByCity(Long id) {
        return productRepository.findByCityId(id);
    }

    @Override
    public List<Product> searchProductByCategory(Long id) {
        return productRepository.findByCategoryId(id);
    }
}
