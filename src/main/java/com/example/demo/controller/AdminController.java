package com.example.demo.controller;

import com.example.demo.model.Brand;
import com.example.demo.model.Category;
import com.example.demo.model.Product;
import com.example.demo.repository.BrandRepository;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.BrandService;
import com.example.demo.service.CategoryService;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

@Controller
public class AdminController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    BrandService brandService;
    @Autowired
    ProductService productService;





    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin(ModelMap modelMap) {
        List<Category> categoryList = categoryService.showAllCategory();
        modelMap.addAttribute("categoryList", categoryList);
        List<Brand> brandList = brandService.showAllBrand();
        modelMap.addAttribute("brandList", brandList);
        return "admin/admin";
    }

    @RequestMapping(value = "/admin/add/category", method = RequestMethod.POST)
    public String addCategory(@ModelAttribute("category") Category category) {
        categoryService.saveCategory(category);
        return "redirect:/admin";

    }

    @RequestMapping(value = "/admin/add/brand", method = RequestMethod.POST)
    public String addBrand(@ModelAttribute("brand") Brand brand) {
        brandService.saveBrand(brand);
        return "redirect:/admin";
    }

    @RequestMapping(value = "/admin/add/product", method = RequestMethod.POST)
    public String addProduct(@ModelAttribute("product") Product product, @RequestParam("file") MultipartFile image) {
        productService.saveProduct(product, image);

        return "redirect:/admin";
    }


}
