package com.example.demo.precios.infrastructure.database.entities;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldNameConstants
@Entity
public class BrandEntity {
  @Id
  private int id;
  private String name;

  @OneToMany(mappedBy = "brand")
  private Set<PricesEntity> prices;
}
