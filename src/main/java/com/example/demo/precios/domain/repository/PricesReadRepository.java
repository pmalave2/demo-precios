package com.example.demo.precios.domain.repository;

import java.time.LocalDateTime;
import java.util.Optional;

import com.example.demo.precios.domain.Prices;

public interface PricesReadRepository {
  Optional<Prices> findBy(LocalDateTime date, int productId, int brandId);
}
