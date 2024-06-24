package com.LTJava.Nhom8_WebKinhDoanhDienGiaDung.service;


import com.LTJava.Nhom8_WebKinhDoanhDienGiaDung.DTO.MonthlyRevenueDTO;
import com.LTJava.Nhom8_WebKinhDoanhDienGiaDung.repository.StatisticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticsService {

    @Autowired
    private StatisticsRepository statisticsRepository;

    public List<MonthlyRevenueDTO> getMonthlyRevenue(int year) {
        return statisticsRepository.findMonthlyRevenue(year);
    }
}
