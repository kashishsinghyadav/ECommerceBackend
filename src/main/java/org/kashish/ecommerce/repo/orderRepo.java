package org.kashish.ecommerce.repo;

import org.kashish.ecommerce.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface orderRepo extends JpaRepository<Order,Long> {

}
