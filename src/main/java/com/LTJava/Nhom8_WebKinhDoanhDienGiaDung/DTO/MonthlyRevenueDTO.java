package com.LTJava.Nhom8_WebKinhDoanhDienGiaDung.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MonthlyRevenueDTO {
    private int month;
    private BigDecimal revenue;
}
