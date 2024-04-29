package com.example.EcommerceApp.Service;

import com.example.EcommerceApp.DAO.ProductDO;
import com.example.EcommerceApp.Repository.EcommProductRepository;
import com.example.EcommerceApp.Repository.EcommCategoryRepository;
import com.example.EcommerceApp.Model.Categories;
import com.example.EcommerceApp.Model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private EcommCategoryRepository ecommCategoryRepository;

    @Autowired
    private EcommProductRepository ecommProductRepository;

    public List<Categories> getAllCategories(){
        return ecommCategoryRepository.findAll();
    }

    public Categories getCategorybyId(Long id) {
        return ecommCategoryRepository.findById(id).orElse(null);
    }

    public void addCategory(Categories category) {
        ecommCategoryRepository.save(category);
    }


    public void deleteCategory(Long id) {
        ecommCategoryRepository.deleteById(id);
    }

    public void updateCategory(Long id, Categories category){
        Categories oldCategory = getCategorybyId(id);
        if(oldCategory != null){
            oldCategory.setCategoryName(category.getCategoryName());
        }
        ecommCategoryRepository.save(oldCategory);
    }
}
