package com.example.demo.precios.domain.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.example.demo.precios.domain.Prices;

public interface PricesRead {
  List<Prices> findBy(LocalDateTime date, int productId, int brandId);
}
