package com.LTJava.Nhom8_WebKinhDoanhDienGiaDung.repository;


import com.LTJava.Nhom8_WebKinhDoanhDienGiaDung.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    // Các phương thức tùy biến (nếu cần)
}
