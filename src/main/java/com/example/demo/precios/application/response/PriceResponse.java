package com.example.demo.precios.application.response;

public record PriceResponse(int productId, int brandId, double priceListValue, String startDate, String endDate, double price) {
}
