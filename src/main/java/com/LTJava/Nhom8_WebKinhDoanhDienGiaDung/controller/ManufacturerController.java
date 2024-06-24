package com.LTJava.Nhom8_WebKinhDoanhDienGiaDung.controller;

import com.LTJava.Nhom8_WebKinhDoanhDienGiaDung.model.Manufacturer;
import com.LTJava.Nhom8_WebKinhDoanhDienGiaDung.service.BrandService;
import com.LTJava.Nhom8_WebKinhDoanhDienGiaDung.service.ManufacturerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/manufacturers")
public class ManufacturerController {

    @Autowired
    private ManufacturerService manufacturerService;

    @Autowired
    private BrandService brandService;

    // Hiển thị danh sách nhà sản xuất
    @GetMapping
    public String showManufacturerList(Model model) {
        model.addAttribute("manufacturers", manufacturerService.getAllManufacturers());
        return "admin/manufacturer/manufacturer-list";
    }

    // Hiển thị form thêm nhà sản xuất
    @GetMapping("/add")
    public String showAddManufacturerForm(Model model) {
        model.addAttribute("manufacturer", new Manufacturer());
        model.addAttribute("brands", brandService.getAllBrands());
        return "admin/manufacturer/add-manufacturer";
    }

    // Xử lý thêm nhà sản xuất
    @PostMapping("/add")
    public String addManufacturer(@Valid @ModelAttribute("manufacturer") Manufacturer manufacturer, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("brands", brandService.getAllBrands());
            return "admin/manufacturer/add-manufacturer";
        }
        manufacturerService.addManufacturer(manufacturer);
        return "redirect:/admin/manufacturers";
    }

    // Hiển thị form sửa nhà sản xuất
    @GetMapping("/edit/{id}")
    public String showEditManufacturerForm(@PathVariable Long id, Model model) {
        Manufacturer manufacturer = manufacturerService.getManufacturerById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid manufacturer Id:" + id));
        model.addAttribute("manufacturer", manufacturer);
        model.addAttribute("brands", brandService.getAllBrands());
        return "admin/manufacturer/update-manufacturer";
    }

    // Xử lý cập nhật nhà sản xuất
    @PostMapping("/update/{id}")
    public String updateManufacturer(@PathVariable Long id, @Valid @ModelAttribute("manufacturer") Manufacturer manufacturer, BindingResult result, Model model) {
        if (result.hasErrors()) {
            manufacturer.setId(id);
            model.addAttribute("brands", brandService.getAllBrands());
            return "admin/manufacturer/update-manufacturer";
        }
        manufacturerService.updateManufacturer(manufacturer);
        return "redirect:/admin/manufacturers";
    }

    // Xử lý xóa nhà sản xuất
    @GetMapping("/delete/{id}")
    public String deleteManufacturer(@PathVariable Long id) {
        manufacturerService.deleteManufacturerById(id);
        return "redirect:/admin/manufacturers";
    }
}
