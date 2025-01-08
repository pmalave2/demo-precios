package com.example.demo.precios.infrastructure.repositories.h2;

import static com.example.demo.precios.TestUtils.getPriceEntities;
import static com.example.demo.precios.infrastructure.repositories.h2.PriceSpecifications.where;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.jpa.domain.Specification;

import com.example.demo.precios.domain.mapper.PriceMapper;
import com.example.demo.precios.domain.repository.PriceReadRepository;

@ExtendWith(MockitoExtension.class)
class H2PricesRepositoryTest {

  SpringDataPriceRepository pricesRepository;
  PriceMapper pricesMapper;
  PriceReadRepository priceReadRepository;

  @BeforeEach
  void eachSetUp() {
    pricesRepository = mock(SpringDataPriceRepository.class);
    pricesMapper = PriceMapper.INSTANCE;
    priceReadRepository = new H2PricesRepository(pricesRepository, pricesMapper);
  }

  @Test
  void givenParams_whenLookingForPrice_thenReturnPriceList() {
    when(pricesRepository.findAll(ArgumentMatchers.<Specification<PriceEntity>>any())).thenReturn(getPriceEntities());

    var response = pricesRepository.findAll(where(35455, 1, LocalDateTime.of(2020, 6, 14, 16, 0)));

    assertEquals(getPriceEntities(), response);
  }
}
