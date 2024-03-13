package com.example.demo.precios;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.example.demo.precios.application.rest.PriceController;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
class PricesIT {
  @Autowired
  MockMvc mvc;

  @ParameterizedTest
  @CsvSource({
      "2020-06-14T10:00:00,35455,1,1,35.50", // Test 1
      "2020-06-14T16:00:00,35455,1,2,25.45", // Test 2
      "2020-06-14T21:00:00,35455,1,1,35.50", // Test 3
      "2020-06-15T10:00:00,35455,1,3,30.50", // Test 4
      "2020-06-16T21:00:00,35455,1,4,38.95"  // Test 5
  })
  void givenPrice_whenGetPrice_thenReturnHttpCode200(String date, int productId, int brandId, int priceList, double price)
      throws Exception {
    MultiValueMap<String, String> params = new LinkedMultiValueMap<>() {
      {
        add("date", date);
        add("productId", String.valueOf(productId));
        add("brandId", String.valueOf(brandId));
      }
    };

    mvc.perform(get(PriceController.ENDPOINT).params(params).accept(MediaType.APPLICATION_JSON)).andDo(print())
        .andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.productId", is(productId))).andExpect(jsonPath("$.brandId", is(brandId)))
        .andExpect(jsonPath("$.priceList", is(priceList))).andExpect(jsonPath("$.startDate").isNotEmpty())
        .andExpect(jsonPath("$.endDate").isNotEmpty()).andExpect(jsonPath("$.price", is(price)));
  }

  @Test
  void givenRequest_whenGetPriceFromBrandDontExists_thenReturnHttpCode404() throws Exception {
    MultiValueMap<String, String> params = new LinkedMultiValueMap<>() {
      {
        add("date", "2020-06-16T21:00:00");
        add("productId", "35455");
        add("brandId", "2");
      }
    };

    mvc.perform(get(PriceController.ENDPOINT).params(params).accept(MediaType.APPLICATION_JSON)).andDo(print())
        .andExpect(status().isBadRequest());
  }
}
