package com.LTJava.Nhom8_WebKinhDoanhDienGiaDung;

import lombok.AllArgsConstructor;
@AllArgsConstructor
public enum Role {
    ADMIN(1),
    USER(2);

    public final long value; // Biến này lưu giá trị số tương ứng với mỗi vai trò.
}
