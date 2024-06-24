package com.LTJava.Nhom8_WebKinhDoanhDienGiaDung.controller;

import com.LTJava.Nhom8_WebKinhDoanhDienGiaDung.model.Product;
import com.LTJava.Nhom8_WebKinhDoanhDienGiaDung.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public String home(Model model) {
        List<Product> topProducts = productService.getTop3Products();
        model.addAttribute("topProducts", topProducts);
        return "home/index";
    }
}
