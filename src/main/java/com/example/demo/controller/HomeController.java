package com.example.demo.controller;

import com.example.demo.model.*;
import com.example.demo.service.BrandService;
import com.example.demo.service.CategoryService;
import com.example.demo.service.ProductService;
import com.example.demo.service.UserService;
import com.example.demo.service.currentUser.CurrentUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.security.Principal;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    BrandService brandService;
    @Autowired
    ProductService productService;
    @Autowired
    UserService userService;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "redirect:/home";
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(ModelMap modelMap) {
        List<Category> categoryList = categoryService.showAllCategory();
        modelMap.addAttribute("categoryList", categoryList);
        List<Brand> brandList = brandService.showAllBrand();
        modelMap.addAttribute("brandList", brandList);
        List<Product> productList = productService.showAllProduct();
        modelMap.addAttribute("productList", productList);
        return "admin/home";
    }

    @ResponseBody
    @RequestMapping(value = "/getImage", method = RequestMethod.GET)
    public byte[] getCoverImage(@RequestParam("imageName") String imageName) throws IOException {
        InputStream inputStream = new FileInputStream("E:\\EShop\\" + imageName);
        return org.apache.commons.io.IOUtils.toByteArray(inputStream);
    }

    @RequestMapping(value = "/home/category/product/{id}", method = RequestMethod.GET)
    public String showAllProductByCategory(@PathVariable("id") long id, ModelMap modelMap) {
        List<Category> categoryList = categoryService.showAllCategory();
        modelMap.addAttribute("categoryList", categoryList);
        List<Brand> brandList = brandService.showAllBrand();
        modelMap.addAttribute("brandList", brandList);
        List<Product> productList = productService.showAllProductByCategory(id);
        modelMap.addAttribute("productList", productList);
        return "admin/home";
    }

    @RequestMapping (value = "/home/brand/product/{id}", method = RequestMethod.GET)
    public String showAllProductByBrand (@PathVariable ("id") long id, ModelMap modelMap) {
        List<Category> categoryList = categoryService.showAllCategory();
        modelMap.addAttribute("categoryList", categoryList);
        List<Brand> brandList = brandService.showAllBrand();
        modelMap.addAttribute("brandList", brandList);
        List<Product> productList = productService.showAllProductByBrand(id);
        modelMap.addAttribute("productList", productList);
        return "admin/home";
    }

    @RequestMapping(value = "/loginPage", method = RequestMethod.GET)
    public String login() {
        return "user/login";
    }


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/loginPage";
    }


    @RequestMapping(value = "/user/welcome", method = RequestMethod.GET)
    public String welcomeUser(@ModelAttribute("currentUser") CurrentUser currentUser, ModelMap modelMap) {
        String name = currentUser.getName();
        modelMap.addAttribute("name", name);

        return "user/userPage";
    }

    @RequestMapping(value = "/roleDispatch")
    public String redirect(RedirectAttributes redirectAttributes) {
        CurrentUser currentUser = (CurrentUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String role = String.valueOf(currentUser.getRole());
        if (role.equals("ADMIN")) {
            return "redirect:/admin";
        } else {
            redirectAttributes.addFlashAttribute("currentUser", currentUser);
            return "redirect:/user/welcome";
        }

    }
//    @RequestMapping (value = "/logout", method = RequestMethod.GET)
//    public String logout (HttpServletRequest request, HttpServletResponse response) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if (authentication!=null) {
//            new SecurityContextLogoutHandler().logout(request, response, authentication);
//        }
//        return "redirect:/home";
//
//    }

}
