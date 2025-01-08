package com.example.demo.precios.infrastructure.repositories.h2;

import java.time.LocalDateTime;

import org.springframework.data.jpa.domain.Specification;

import lombok.experimental.UtilityClass;

@UtilityClass
public class PriceSpecifications {

  public static Specification<PriceEntity> where(int brandId, int productId, LocalDateTime date) {
    return (root, query, builder) -> {
      var brandIdIdEqual = builder.equal(root.get(PriceEntity_.BRAND_ID), brandId);
      var productIdEqual = builder.equal(root.get(PriceEntity_.PRODUCT_ID), productId);
      var dateBetween = builder.between(builder.literal(date), root.get(PriceEntity_.START_DATE),
          root.get(PriceEntity_.END_DATE));

      return builder.and(brandIdIdEqual, productIdEqual, dateBetween);
    };
  }
}
