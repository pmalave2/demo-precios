package com.example.demo.precios.infrastructure.repositories;

import static com.example.demo.precios.infrastructure.repositories.PricesSpecifications.where;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.precios.domain.Prices;
import com.example.demo.precios.domain.mapper.PricesMapper;
import com.example.demo.precios.domain.repository.PricesRead;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PricesAdapter implements PricesRead {
  private PricesRepository pricesRepository;
  private PricesMapper pricesMapper;

  @Override
  public Optional<Prices> findBy(LocalDateTime date, int productId, int brandId) {
    return pricesRepository.findOne(where(brandId, productId, date)).map(pricesMapper::mapToDomain).or(Optional::empty);
  }
}
