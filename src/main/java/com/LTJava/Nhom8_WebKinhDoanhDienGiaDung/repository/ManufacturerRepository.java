package com.LTJava.Nhom8_WebKinhDoanhDienGiaDung.repository;


import com.LTJava.Nhom8_WebKinhDoanhDienGiaDung.model.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManufacturerRepository extends JpaRepository<Manufacturer,Long> {
}
