package com.example.demo.precios.domain.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.example.demo.precios.domain.Price;

public interface PriceReadRepository {
  List<Price> findAllBy(LocalDateTime date, int productId, int brandId);
}
