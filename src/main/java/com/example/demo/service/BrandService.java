package com.example.demo.service;

import com.example.demo.model.Brand;
import com.example.demo.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Max;
import java.util.List;

@Service
public class BrandService {

    @Autowired
    BrandRepository brandRepository;

    public void saveBrand(Brand brand) {
        brandRepository.save(brand);

    }


    public List<Brand> showAllBrand() {
        return brandRepository.findAll();
    }
}
