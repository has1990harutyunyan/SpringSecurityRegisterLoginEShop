package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ProductDetailsController {

    @Autowired
    ProductService productService;

    @RequestMapping(value = "/productDetails/{id}")
    public String productDetails(@PathVariable("id") long id, ModelMap modelMap) {
        Product product = productService.showProductById(id);
        modelMap.addAttribute("product", product);

        List<Product> productListNotLikeId = productService.showRecommendedProducts(id, product.getCategory().getId());
        modelMap.addAttribute("productListNotLikeId",productListNotLikeId);
        return "/admin/productDetails";

    }
}
