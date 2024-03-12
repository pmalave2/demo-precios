package com.example.demo.precios;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
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

  @Test
  void givenPrice_Test_1() throws Exception {
    MultiValueMap<String, String> params = new LinkedMultiValueMap<>() {
      {
        add("date", "2020-06-14T10:00:00");
        add("productId", "35455");
        add("brandId", "1");
      }
    };

    mvc.perform(get(PriceController.ENDPOINT).params(params).accept(MediaType.APPLICATION_JSON)).andDo(print())
        .andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.price", is(35.5)));
  }

  @Test
  void givenPrice_Test_2() throws Exception {
    MultiValueMap<String, String> params = new LinkedMultiValueMap<>() {
      {
        add("date", "2020-06-14T16:00:00");
        add("productId", "35455");
        add("brandId", "1");
      }
    };

    mvc.perform(get(PriceController.ENDPOINT).params(params).accept(MediaType.APPLICATION_JSON)).andDo(print())
        .andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.price", is(25.45)));
  }

  @Test
  void givenPrice_Test_3() throws Exception {
    MultiValueMap<String, String> params = new LinkedMultiValueMap<>() {
      {
        add("date", "2020-06-14T21:00:00");
        add("productId", "35455");
        add("brandId", "1");
      }
    };

    mvc.perform(get(PriceController.ENDPOINT).params(params).accept(MediaType.APPLICATION_JSON)).andDo(print())
        .andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.price", is(35.50)));
  }

  @Test
  void givenPrice_Test_4() throws Exception {
    MultiValueMap<String, String> params = new LinkedMultiValueMap<>() {
      {
        add("date", "2020-06-15T10:00:00");
        add("productId", "35455");
        add("brandId", "1");
      }
    };

    mvc.perform(get(PriceController.ENDPOINT).params(params).accept(MediaType.APPLICATION_JSON)).andDo(print())
        .andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.price", is(30.50)));
  }

  @Test
  void givenPrice_Test_5() throws Exception {
    MultiValueMap<String, String> params = new LinkedMultiValueMap<>() {
      {
        add("date", "2020-06-16T21:00:00");
        add("productId", "35455");
        add("brandId", "1");
      }
    };

    mvc.perform(get(PriceController.ENDPOINT).params(params).accept(MediaType.APPLICATION_JSON)).andDo(print())
        .andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.price", is(38.95)));
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
        .andExpect(status().isNotFound());
  }
}
