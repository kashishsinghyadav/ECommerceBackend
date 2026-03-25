package org.kashish.ecommerce.repo;

import org.kashish.ecommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface productRepo  extends JpaRepository<Product,Integer> {

}
