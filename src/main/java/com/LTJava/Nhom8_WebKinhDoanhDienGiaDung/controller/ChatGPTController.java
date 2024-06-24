package com.LTJava.Nhom8_WebKinhDoanhDienGiaDung.controller;

import com.LTJava.Nhom8_WebKinhDoanhDienGiaDung.service.ChatGPTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;

@RestController
public class ChatGPTController {

    @Autowired
    private ChatGPTService chatGPTService;

    @GetMapping("/chat")
    public String chat(@RequestParam String prompt) {
        try {
            return chatGPTService.getResponse(prompt);
        } catch (IOException e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }
}

