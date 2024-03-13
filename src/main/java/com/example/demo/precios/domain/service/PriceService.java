package com.example.demo.precios.domain.service;

import java.time.LocalDateTime;

import com.example.demo.precios.application.response.ReadPriceResponse;

public interface PriceService {
  ReadPriceResponse findBy(LocalDateTime date, int productId, int brandId);
}
