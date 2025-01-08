package com.example.demo.precios.infrastructure.repositories.h2;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "prices")
public class PriceEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;
  private int brandId;
  private LocalDateTime startDate;
  private LocalDateTime endDate;
  private int priceList;
  private int productId;
  private int priority;
  private double price;
  private String currency;
}
