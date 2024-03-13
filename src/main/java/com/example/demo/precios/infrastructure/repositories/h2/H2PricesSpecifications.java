package com.example.demo.precios.infrastructure.repositories.h2;

import java.time.LocalDateTime;

import org.springframework.data.jpa.domain.Specification;

import lombok.experimental.UtilityClass;

@UtilityClass
public class H2PricesSpecifications {

  public static Specification<PricesEntity> where(int brandId, int productId, LocalDateTime date) {
    return (root, query, builder) -> {
      var sub = query.subquery(Integer.class);
      var subRoot = sub.from(PricesEntity.class);
      sub.select(builder.max(subRoot.get(PricesEntity_.priority)));
      sub.where(builder.equal(subRoot.get(PricesEntity_.brandId), brandId),
          builder.equal(subRoot.get(PricesEntity_.productId), productId),
          builder.between(builder.literal(date), subRoot.get(PricesEntity_.startDate), subRoot.get(PricesEntity_.endDate)));
      var maxPriority = builder.equal(root.get(PricesEntity_.priority), sub);

      var brandIdIdEqual = builder.equal(root.get(PricesEntity_.brandId), brandId);
      var productIdEqual = builder.equal(root.get(PricesEntity_.productId), productId);
      var dateBetween = builder.between(builder.literal(date), root.get(PricesEntity_.startDate),
          root.get(PricesEntity_.endDate));

      return builder.and(brandIdIdEqual, productIdEqual, dateBetween, maxPriority);
    };
  }
}
