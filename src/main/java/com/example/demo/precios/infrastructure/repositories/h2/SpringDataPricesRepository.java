package com.example.demo.precios.infrastructure.repositories.h2;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SpringDataPricesRepository extends JpaRepository<PricesEntity, UUID>, JpaSpecificationExecutor<PricesEntity> {
}
