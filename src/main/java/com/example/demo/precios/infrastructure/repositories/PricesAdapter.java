package com.example.demo.precios.infrastructure.repositories;

import static com.example.demo.precios.infrastructure.repositories.PricesSpecifications.byBrandId;
import static com.example.demo.precios.infrastructure.repositories.PricesSpecifications.byDateRange;
import static com.example.demo.precios.infrastructure.repositories.PricesSpecifications.byProductId;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.jpa.domain.Specification;
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
  public List<Prices> findBy(LocalDateTime date, int productId, int brandId) {
    return pricesRepository.findAll(Specification.where(byBrandId(brandId)).and(byProductId(productId).and(byDateRange(date))))
        .stream().map(pricesMapper::mapToDomain).collect(Collectors.toList());
  }
}
