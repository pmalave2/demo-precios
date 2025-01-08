package com.example.demo.precios.infrastructure.repositories.h2;

import static com.example.demo.precios.infrastructure.repositories.h2.PriceSpecifications.where;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.precios.domain.Price;
import com.example.demo.precios.domain.mapper.PriceMapper;
import com.example.demo.precios.domain.repository.PriceReadRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class H2PricesRepository implements PriceReadRepository {
  private SpringDataPriceRepository pricesRepository;
  private PriceMapper pricesMapper;

  @Override
  public List<Price> findAllBy(LocalDateTime date, int productId, int brandId) {
    return pricesRepository.findAll(where(brandId, productId, date)).stream().map(pricesMapper::mapToDomain).toList();
  }
}
