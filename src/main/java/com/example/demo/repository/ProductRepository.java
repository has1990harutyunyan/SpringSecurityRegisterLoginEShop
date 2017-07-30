package com.example.demo.repository;


import com.example.demo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findDistinctTop6ByOrderByCostAsc();

    Product findById(long id);


    List<Product> findAllByIdNotLikeAndCategoryId(long id, long categoryId);

    List<Product> findAllByCategoryId(long id);

    List<Product> findAllByBrandId(long id);

}
