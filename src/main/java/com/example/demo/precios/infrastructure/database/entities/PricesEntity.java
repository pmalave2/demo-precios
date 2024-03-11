package com.example.demo.precios.infrastructure.database.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
public class PricesEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;
  private LocalDateTime startDate;
  private LocalDateTime endDate;
  private int productId;
  private int priority;
  private double price;
  private String currency;

  @ManyToOne
  private BrandEntity brand;

  @ManyToOne
  private PriceListEntity priceList;
}
