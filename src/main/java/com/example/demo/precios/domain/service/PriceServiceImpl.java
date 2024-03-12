package com.example.demo.precios.domain.service;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.precios.application.response.PriceResponse;
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
    return pricesRead.findBy(date, productId, brandId).map(pricesMapper::mapToResponse)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Price not found"));
  }
}
