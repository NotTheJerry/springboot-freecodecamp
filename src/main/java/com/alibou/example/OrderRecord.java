package com.alibou.example;

public record OrderRecord(
        String customerName,
        String productName,
        int quantity
) {
}