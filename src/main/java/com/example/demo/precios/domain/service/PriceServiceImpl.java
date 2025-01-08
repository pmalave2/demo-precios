package com.example.demo.precios.domain.service;

import java.time.LocalDateTime;
import java.util.Comparator;

import org.springframework.stereotype.Service;

import com.example.demo.precios.application.response.ReadPriceResponse;
import com.example.demo.precios.domain.Price;
import com.example.demo.precios.domain.exceptions.PriceNotFoundDomainException;
import com.example.demo.precios.domain.mapper.PriceMapper;
import com.example.demo.precios.domain.repository.PriceReadRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PriceServiceImpl implements PriceService {
  private PriceReadRepository pricesRead;
  private PriceMapper pricesMapper;

  @Override
  public ReadPriceResponse findBy(LocalDateTime date, int productId, int brandId) {
    return pricesRead.findAllBy(date, productId, brandId).stream()
        .max(Comparator.comparing(Price::priority))
        .map(pricesMapper::mapToResponse)
        .orElseThrow(PriceNotFoundDomainException::new);
  }
}
