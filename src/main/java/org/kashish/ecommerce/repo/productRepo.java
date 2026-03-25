package org.kashish.ecommerce.repo;

import org.kashish.ecommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface productRepo  extends JpaRepository<Product,Integer> {

}
