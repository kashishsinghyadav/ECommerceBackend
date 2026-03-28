package org.kashish.ecommerce.repo;

import org.kashish.ecommerce.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface orderRepo extends JpaRepository<Order,Long> {

   Optional<Order> findByOrderId(String orderId);

}
