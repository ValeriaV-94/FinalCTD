package com.integrador.backend.repository;

import com.integrador.backend.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCityId(Long cities_id);
    List<Product> findByCategoryId(Long categories_id);

}
