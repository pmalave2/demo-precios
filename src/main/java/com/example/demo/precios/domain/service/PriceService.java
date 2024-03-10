package com.example.demo.precios.domain.service;

import java.time.LocalDateTime;

import com.example.demo.precios.application.response.PriceResponse;

public interface PriceService {
  PriceResponse findBy(LocalDateTime date, int productId, int brandId);
}
