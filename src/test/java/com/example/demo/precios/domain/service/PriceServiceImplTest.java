package com.example.demo.precios.domain.service;

import static com.example.demo.precios.TestUtils.getPrices;
import static com.example.demo.precios.TestUtils.getReadPriceResponse2;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.precios.domain.exceptions.PriceNotFoundDomainException;
import com.example.demo.precios.domain.mapper.PriceMapper;
import com.example.demo.precios.domain.repository.PriceReadRepository;

@ExtendWith(MockitoExtension.class)
class PriceServiceImplTest {

  PriceReadRepository pricesRead;
  PriceMapper pricesMapper;
  PriceService priceService;

  @BeforeEach
  void eachSetUp() {
    pricesRead = mock(PriceReadRepository.class);
    pricesMapper = PriceMapper.INSTANCE;
    priceService = new PriceServiceImpl(pricesRead, pricesMapper);
  }

  @Test
  void givenParams_whenLookingForPrice_thenReturnReadPriceResponse() {
    when(pricesRead.findAllBy(any(LocalDateTime.class), anyInt(), anyInt())).thenReturn(getPrices());

    var response = priceService.findBy(LocalDateTime.of(2020, 6, 14, 16, 0), 35455, 1);

    assertEquals(getReadPriceResponse2(), response);
  }

  @Test
  void givenParams_whenLookingForPriceButThereIsNotRecords_thenReturnPriceNotFoundDomainException() {
    when(pricesRead.findAllBy(any(LocalDateTime.class), anyInt(), eq(2))).thenThrow(new PriceNotFoundDomainException());

    assertThrows(PriceNotFoundDomainException.class,
        () -> priceService.findBy(LocalDateTime.of(2020, 6, 14, 16, 0), 35455, 2));
  }
}
