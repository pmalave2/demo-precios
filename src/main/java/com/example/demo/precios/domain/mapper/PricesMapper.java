package com.example.demo.precios.domain.mapper;

import org.mapstruct.Mapper;

import com.example.demo.precios.application.response.ReadPriceResponse;
import com.example.demo.precios.domain.Prices;
import com.example.demo.precios.infrastructure.repositories.h2.PricesEntity;

@Mapper(componentModel = "spring")
public interface PricesMapper {
  Prices mapToDomain(PricesEntity pricesEntity);

  ReadPriceResponse mapToResponse(Prices price);
}
