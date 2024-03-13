package com.example.demo.precios.domain.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.example.demo.precios.application.response.ReadPriceResponse;
import com.example.demo.precios.domain.exceptions.PriceNotFoundDomainException;
import com.example.demo.precios.domain.mapper.PricesMapper;
import com.example.demo.precios.domain.repository.PricesReadRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PriceServiceImpl implements PriceService {
  private PricesReadRepository pricesRead;
  private PricesMapper pricesMapper;

  @Override
  public ReadPriceResponse findBy(LocalDateTime date, int productId, int brandId) {
    return pricesRead.findBy(date, productId, brandId).map(pricesMapper::mapToResponse)
        .orElseThrow(PriceNotFoundDomainException::new);
  }
}
