package com.example.demo.precios.domain.mapper;

import org.mapstruct.Mapper;

import com.example.demo.precios.application.response.PriceResponse;
import com.example.demo.precios.domain.Prices;
import com.example.demo.precios.infrastructure.database.entities.PricesEntity;

@Mapper(componentModel = "spring")
public interface PricesMapper {
  Prices mapToDomain(PricesEntity pricesEntity);

  PriceResponse mapToResponse(Prices prices);
}
