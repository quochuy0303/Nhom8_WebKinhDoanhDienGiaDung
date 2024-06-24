package com.LTJava.Nhom8_WebKinhDoanhDienGiaDung.controller;

import com.LTJava.Nhom8_WebKinhDoanhDienGiaDung.model.*;
import com.LTJava.Nhom8_WebKinhDoanhDienGiaDung.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private ManufacturerService manufacturerService;

    @Autowired
    private BrandService brandService;

    private final UserService userService;

    @Autowired
    public AdminController(@Lazy UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        List<Product> products = productService.getAllProducts();
        List<Manufacturer> manufacturers = manufacturerService.getAllManufacturers();
        List<Brand> brands = brandService.getAllBrands();
        List<User> users = userService.getAllUsers();

        model.addAttribute("products", products);
        model.addAttribute("manufacturers", manufacturers);
        model.addAttribute("brands", brands);
        model.addAttribute("users", users);

        return "admin/index";
    }

    @GetMapping("/orders")
    public String listOrders(Model model) {
        List<Order> orders = orderService.getAllOrders();
        model.addAttribute("orders", orders);
        return "admin/order/list-order";
    }

    @PostMapping("/orders/update-status")
    public String updateOrderStatus(@RequestParam Long orderId, @RequestParam OrderStatus status) {
        Order order = orderService.getOrderById(orderId);
        if (order != null) {
            order.setOrderStatus(status);
            orderService.save(order);
        }
        return "redirect:/admin/orders";
    }

    @GetMapping("user")
    public String user(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "admin/user/list-user";
    }

    @PostMapping("user/delete")
    public String deleteUser(@RequestParam Long id) {
        userService.deleteUser(id);
        return "redirect:/admin/user";
    }

    @GetMapping("/other-page")
    public String otherPage() {
        return "admin/404";
    }
}
