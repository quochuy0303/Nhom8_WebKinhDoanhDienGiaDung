package com.LTJava.Nhom8_WebKinhDoanhDienGiaDung.service;


import com.LTJava.Nhom8_WebKinhDoanhDienGiaDung.model.CartItem;
import com.LTJava.Nhom8_WebKinhDoanhDienGiaDung.model.Product;
import com.LTJava.Nhom8_WebKinhDoanhDienGiaDung.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.math.BigDecimal;
import java.util.*;

@Service
@SessionScope
public class CartService {
    @Autowired
    private ProductRepository productRepository;

    private List<CartItem> cartItems = new ArrayList<>();

    public void addToCart(Long productId, int quantity) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("Product not found: " + productId));

        CartItem existingCartItem = cartItems.stream()
                .filter(item -> item.getProduct().getId().equals(productId))
                .findFirst()
                .orElse(null);

        if (existingCartItem != null) {
            existingCartItem.setQuantity(existingCartItem.getQuantity() + quantity);
        } else {
            cartItems.add(new CartItem(product, quantity));
        }
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void removeFromCart(Long productId) {
        cartItems.removeIf(item -> item.getProduct().getId() == productId);
    }

    public void clearCart() {
        cartItems.clear();
    }

    public BigDecimal getTotalPrice() {
        return cartItems.stream()
                .map(item -> item.getProduct().getPrice().multiply(BigDecimal.valueOf(item.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
