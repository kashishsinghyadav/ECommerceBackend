package org.kashish.ecommerce.repo;

import jakarta.persistence.criteria.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface orderRepo extends JpaRepository<Order,Integer> {

}
