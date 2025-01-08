package com.example.demo.precios.application.rest;

import static com.example.demo.precios.TestUtils.getParams;
import static com.example.demo.precios.TestUtils.getParamsWithout;
import static com.example.demo.precios.TestUtils.getReadPriceResponse;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.MultiValueMap;

import com.example.demo.precios.domain.service.PriceService;

@WebMvcTest(PriceController.class)
class PriceControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockitoBean
  PriceService priceService;

  @ParameterizedTest
  @MethodSource("getParamsWithoutSomeParams")
  void givenPriceRequest_whenOneOfRequiredRequestParamsAreNotSend_thenReturnHttpCode404(
      MultiValueMap<String, String> params) throws Exception {
    mockMvc.perform(get(PriceController.ENDPOINT).params(params).accept(MediaType.APPLICATION_JSON)).andDo(print())
        .andExpect(status().isBadRequest());
  }

  static Stream<MultiValueMap<String, String>> getParamsWithoutSomeParams() {
    return Stream.of(getParamsWithout("date"), getParamsWithout("productId"), getParamsWithout("brandId"));
  }

  @Test
  void givenPriceRequest_whenNoRequestParamsAreSend_thenReturnHttpCode404() throws Exception {
    mockMvc.perform(get(PriceController.ENDPOINT).accept(MediaType.APPLICATION_JSON)).andDo(print())
        .andExpect(status().isBadRequest());
  }

  @Test
  void givenPriceRequest_whenRequiredRequestParamsAreSend_thenReturnHttpCode200() throws Exception {
    when(priceService.findBy(any(LocalDateTime.class), anyInt(), anyInt())).thenReturn(getReadPriceResponse());

    mockMvc.perform(get(PriceController.ENDPOINT).params(getParams()).accept(MediaType.APPLICATION_JSON)).andDo(print())
        .andExpect(status().isOk()).andExpect(content().json(
            "{\"productId\":35455,\"brandId\":1,\"priceList\":1,\"startDate\":\"2020-06-14T00:00:00\",\"endDate\":\"2020-12-31T23:59:59\",\"price\":35.5}"));
  }
}
