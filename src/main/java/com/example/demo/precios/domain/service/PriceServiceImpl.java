package com.example.demo.precios.domain.service;

import java.time.LocalDateTime;
import java.util.Comparator;

import org.springframework.stereotype.Service;

import com.example.demo.precios.application.response.PriceResponse;
import com.example.demo.precios.domain.Prices;
import com.example.demo.precios.domain.mapper.PricesMapper;
import com.example.demo.precios.domain.repository.PricesRead;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PriceServiceImpl implements PriceService {
  private PricesRead pricesRead;
  private PricesMapper pricesMapper;

  @Override
  public PriceResponse findBy(LocalDateTime date, int productId, int brandId) {
    Prices p = pricesRead.findBy(date, productId, brandId).stream()
        .sorted(Comparator.comparingInt(Prices::priority).reversed()).findFirst().orElse(null);
    return pricesMapper.mapToResponse(p);
  }
}
