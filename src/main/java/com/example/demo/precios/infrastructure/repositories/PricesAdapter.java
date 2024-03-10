package com.example.demo.precios.infrastructure.repositories;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.precios.domain.Prices;
import com.example.demo.precios.domain.mapper.PricesMapper;
import com.example.demo.precios.domain.repository.PricesRead;
import com.example.demo.precios.infrastructure.database.entities.BrandEntity;
import com.example.demo.precios.infrastructure.database.entities.PricesEntity;

import jakarta.persistence.criteria.Join;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PricesAdapter implements PricesRead {
  private PricesRepository pricesRepository;
  private PricesMapper pricesMapper;

  @Override
  public List<Prices> findBy(LocalDateTime date, int productId, int brandId) {
    List<PricesEntity> list = pricesRepository.findAll((root, query, builder) -> {
      Join<PricesEntity, BrandEntity> joinBrand = root.join(PricesEntity.Fields.brand);
      return builder.and(builder.equal(joinBrand.get(BrandEntity.Fields.id), brandId),
          builder.between(builder.literal(date), root.get(PricesEntity.Fields.startDate), root.get(PricesEntity.Fields.endDate)),
          builder.equal(root.get(PricesEntity.Fields.productId), productId));
    });

    return list.stream().map(pricesMapper::mapToDomain).collect(Collectors.toList());
  }
}
