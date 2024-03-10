package com.example.demo.precios.infrastructure.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.example.demo.precios.infrastructure.database.entities.PricesEntity;

public interface PricesRepository extends JpaRepository<PricesEntity, UUID>, JpaSpecificationExecutor<PricesEntity> {
}
