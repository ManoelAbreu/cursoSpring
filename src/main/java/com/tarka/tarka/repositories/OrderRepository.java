package com.tarka.tarka.repositories;

import com.tarka.tarka.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository <Order, Long> {

}
