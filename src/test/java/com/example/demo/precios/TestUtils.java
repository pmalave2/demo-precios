package com.example.demo.precios;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.example.demo.precios.application.response.ReadPriceResponse;
import com.example.demo.precios.domain.Price;
import com.example.demo.precios.infrastructure.repositories.h2.PriceEntity;

import lombok.experimental.UtilityClass;

@UtilityClass
public class TestUtils {
  public static final String PROFILE = "test";

  public static MultiValueMap<String, String> getParams() {
    return new LinkedMultiValueMap<>() {
      {
        add("date", "2020-06-16T21:00:00");
        add("productId", "35455");
        add("brandId", "1");
      }
    };
  }

  public static MultiValueMap<String, String> getParamsWithout(String param) {
    var map = getParams();
    map.remove(param);
    return map;
  }

  public static ReadPriceResponse getReadPriceResponse() {
    return ReadPriceResponse.builder().productId(35455).brandId(1).priceList(1)
        .startDate(LocalDateTime.of(2020, 6, 14, 0, 0))
        .endDate(LocalDateTime.of(2020, 12, 31, 23, 59, 59)).price(35.5).build();
  }

  public static ReadPriceResponse getReadPriceResponse2() {
    return ReadPriceResponse.builder().productId(35455).brandId(1).priceList(2)
        .startDate(LocalDateTime.of(2020, 6, 14, 15, 0))
        .endDate(LocalDateTime.of(2020, 06, 14, 18, 30)).price(25.45).build();
  }

  public static List<Price> getPrices() {
    return List.of(
        Price.builder().brandId(1).productId(35455).priceList(1).startDate(LocalDateTime.of(2020, 6, 14, 0, 0))
            .endDate(LocalDateTime.of(2020, 12, 31, 23, 59, 59)).price(35.5).priority(0).build(),
        Price.builder().brandId(1).productId(35455).priceList(2).startDate(LocalDateTime.of(2020, 6, 14, 15, 0))
            .endDate(LocalDateTime.of(2020, 6, 14, 18, 30)).price(25.45).priority(1).build());
  }

  public static List<PriceEntity> getPriceEntities() {
    return List.of(
        PriceEntity.builder().brandId(1).productId(35455).priceList(1).startDate(LocalDateTime.of(2020, 6, 14, 0, 0))
            .endDate(LocalDateTime.of(2020, 12, 31, 23, 59, 59)).price(35.5).priority(0).build(),
        PriceEntity.builder().brandId(1).productId(35455).priceList(2).startDate(LocalDateTime.of(2020, 6, 14, 15, 0))
            .endDate(LocalDateTime.of(2020, 6, 14, 18, 30)).price(25.45).priority(1).build());
  }
}
