package com.example.demo.precios.application.response;

public record PriceResponse(int productId, int brandId, int priceList, String startDate, String endDate, double price) {
}
