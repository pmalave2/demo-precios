package com.example.demo.precios.infrastructure.repositories.h2;

import static com.example.demo.precios.infrastructure.repositories.h2.H2PricesSpecifications.where;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.precios.domain.Prices;
import com.example.demo.precios.domain.mapper.PricesMapper;
import com.example.demo.precios.domain.repository.PricesReadRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class H2PricesRepository implements PricesReadRepository {
  private SpringDataPricesRepository pricesRepository;
  private PricesMapper pricesMapper;

  @Override
  public Optional<Prices> findBy(LocalDateTime date, int productId, int brandId) {
    return pricesRepository.findOne(where(brandId, productId, date)).map(pricesMapper::mapToDomain).or(Optional::empty);
  }
}
