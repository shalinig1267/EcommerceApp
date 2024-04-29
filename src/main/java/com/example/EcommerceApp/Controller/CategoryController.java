package com.example.EcommerceApp.Controller;

import com.example.EcommerceApp.Model.Categories;
import com.example.EcommerceApp.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class CategoryController {

    @Autowired
    private CategoryService ecommService;

    @GetMapping("/categories")
    public List<Categories> getAllCategories(){
       return ecommService.getAllCategories();
    }

    @GetMapping("/category/{id}")
    public Categories getCategoryByID(@PathVariable Long id){
        return ecommService.getCategorybyId(id);
    }

    @PostMapping("/categories")
    public void addCategory(@RequestBody Categories category){
        ecommService.addCategory(category);
    }

    @DeleteMapping("/categories/{id}")
    public void deleteCategory(@PathVariable Long id){
        ecommService.deleteCategory(id);
    }

    @PutMapping("/categories/{id}")
    public void updateCategory(@PathVariable Long id, @RequestBody Categories category){
        ecommService.updateCategory(id, category);
    }

}
