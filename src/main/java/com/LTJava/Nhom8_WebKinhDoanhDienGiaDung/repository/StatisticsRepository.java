package com.LTJava.Nhom8_WebKinhDoanhDienGiaDung.repository;


import com.LTJava.Nhom8_WebKinhDoanhDienGiaDung.DTO.MonthlyRevenueDTO;
import com.LTJava.Nhom8_WebKinhDoanhDienGiaDung.model.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatisticsRepository extends CrudRepository<Order, Long> {

    @Query("SELECT new com.LTJava.Nhom8_WebKinhDoanhDienGiaDung.DTO.MonthlyRevenueDTO(MONTH(o.orderDate), SUM(o.totalAmount)) " +
            "FROM Order o WHERE YEAR(o.orderDate) = :year GROUP BY MONTH(o.orderDate)")
    List<MonthlyRevenueDTO> findMonthlyRevenue(int year);
}
