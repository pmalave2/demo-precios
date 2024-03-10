package com.example.demo.precios.application.rest;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.precios.application.response.PriceResponse;
import com.example.demo.precios.domain.service.PriceService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("prices")
public class PriceController {
  private PriceService priceService;

  @GetMapping
  public PriceResponse getPrice(@RequestParam LocalDateTime date, @RequestParam int productId, @RequestParam int brandId) {
    return priceService.findBy(date, productId, brandId);
  }
}
