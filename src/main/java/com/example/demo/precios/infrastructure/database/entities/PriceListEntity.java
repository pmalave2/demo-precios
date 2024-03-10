package com.example.demo.precios.infrastructure.database.entities;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PriceListEntity {
  @Id
  private int id;
  private double price;

  @OneToMany(mappedBy = "priceList")
  private Set<PricesEntity> prices;
}
