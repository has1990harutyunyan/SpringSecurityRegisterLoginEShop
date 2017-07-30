package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;


    public void saveProduct(Product product, MultipartFile image) {
        File file = new File("E:\\EShop\\");
        if (!file.exists()) {
            file.mkdir();
        }
        String fileName = System.currentTimeMillis() + "_" + image.getOriginalFilename();
        try {
            File f = new File(file.getAbsolutePath() + "\\" + fileName);
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(f));
            out.write(image.getBytes());
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        product.setMainPic(fileName);
        productRepository.saveAndFlush(product);


    }

    public List<Product> showAllProduct() {
        return productRepository.findDistinctTop6ByOrderByCostAsc();
    }

    public Product showProductById(long id) {
        return productRepository.findById(id);
    }

    public List<Product> showRecommendedProducts(long id, long categoryId) {
        return productRepository.findAllByIdNotLikeAndCategoryId(id, categoryId);
    }

    public List<Product> showAllProductByCategory(long id) {
        return productRepository.findAllByCategoryId(id);

    }

    public List<Product> showAllProductByBrand (long id) {
        return productRepository.findAllByBrandId(id);
    }

}
