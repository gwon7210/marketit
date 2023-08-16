package com.test.marketit.repository;

import com.test.marketit.domain.OrderProducts;
import com.test.marketit.domain.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderProductsRepository extends JpaRepository<OrderProducts, Long> {

}
