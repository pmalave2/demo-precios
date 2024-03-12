package com.example.demo.precios.infrastructure.repositories;

import java.time.LocalDateTime;

import org.springframework.data.jpa.domain.Specification;

import com.example.demo.precios.infrastructure.database.entities.PricesEntity;

import lombok.experimental.UtilityClass;

@UtilityClass
public class PricesSpecifications {

  public static Specification<PricesEntity> where(int brandId, int productId, LocalDateTime date) {
    return (root, query, builder) -> {
      var sub = query.subquery(Integer.class);
      var subRoot = sub.from(PricesEntity.class);
      sub.select(builder.max(subRoot.get(PricesEntity.Fields.priority)));
      sub.where(builder.equal(subRoot.get(PricesEntity.Fields.brandId), brandId),
          builder.equal(subRoot.get(PricesEntity.Fields.productId), productId), builder.between(builder.literal(date),
              subRoot.get(PricesEntity.Fields.startDate), subRoot.get(PricesEntity.Fields.endDate)));
      var maxPriority = builder.equal(root.get(PricesEntity.Fields.priority), sub);

      var brandIdIdEqual = builder.equal(root.get(PricesEntity.Fields.brandId), brandId);
      var productIdEqual = builder.equal(root.get(PricesEntity.Fields.productId), productId);
      var dateBetween = builder.between(builder.literal(date), root.get(PricesEntity.Fields.startDate),
          root.get(PricesEntity.Fields.endDate));

      return builder.and(brandIdIdEqual, productIdEqual, dateBetween, maxPriority);
    };
  }
}
