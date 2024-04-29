package com.example.EcommerceApp.Repository;

import com.example.EcommerceApp.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EcommProductRepository extends JpaRepository<Product, Long> {

}
