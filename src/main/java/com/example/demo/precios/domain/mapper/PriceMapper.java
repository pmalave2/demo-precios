package com.example.demo.precios.domain.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.demo.precios.application.response.ReadPriceResponse;
import com.example.demo.precios.domain.Price;
import com.example.demo.precios.infrastructure.repositories.h2.PriceEntity;

@Mapper(componentModel = "spring")
public interface PriceMapper {

  PriceMapper INSTANCE = Mappers.getMapper(PriceMapper.class);

  Price mapToDomain(PriceEntity pricesEntity);

  ReadPriceResponse mapToResponse(Price price);
}
