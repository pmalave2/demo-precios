package com.example.demo.precios.infrastructure.repositories;

import java.time.LocalDateTime;

import org.springframework.data.jpa.domain.Specification;

import com.example.demo.precios.infrastructure.database.entities.PricesEntity;

import lombok.experimental.UtilityClass;

@UtilityClass
public class PricesSpecifications {
  public static Specification<PricesEntity> byBrandId(int brandId) {
    return (root, query, builder) -> builder.equal(root.get(PricesEntity.Fields.brandId), brandId);
  }

  public static Specification<PricesEntity> byProductId(int productId) {
    return (root, query, builder) -> builder.equal(root.get(PricesEntity.Fields.productId), productId);
  }

  public static Specification<PricesEntity> byDateRange(LocalDateTime date) {
    return (root, query, builder) -> builder.between(builder.literal(date), root.get(PricesEntity.Fields.startDate),
        root.get(PricesEntity.Fields.endDate));
  }
}
