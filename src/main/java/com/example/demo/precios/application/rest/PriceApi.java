package com.example.demo.precios.application.rest;

import java.time.LocalDateTime;

import com.example.demo.precios.application.response.ReadPriceResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Price", description = "Price Api")
public interface PriceApi {
  @Operation(summary = "Fetch a price", description = "fetch a price by date, product and brand")
  @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successful operation"),
      @ApiResponse(responseCode = "400", description = "Price Not Found", content = @Content) })
  ReadPriceResponse getPrice(@Parameter(description = "Application Date", example = "2020-06-14T10:00:00") LocalDateTime date,
      @Parameter(description = "Product ID", example = "35455") int productId,
      @Parameter(description = "Brand ID", example = "1") int brandId);
}
