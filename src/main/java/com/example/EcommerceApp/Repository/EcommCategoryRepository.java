package com.example.EcommerceApp.Repository;

import com.example.EcommerceApp.Model.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EcommCategoryRepository extends JpaRepository<Categories,Long> {
}
