package com.example.EcommerceApp.Controller;

import com.example.EcommerceApp.DAO.ProductDO;
import com.example.EcommerceApp.Model.Product;
import com.example.EcommerceApp.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/product")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();

    }

    @GetMapping("/product/{id}")
    public Product getProductById(@PathVariable Long id){
        return productService.getProductbyId(id);
    }

    @PostMapping("/product")
    public void addProduct(@RequestBody ProductDO productDO){
        productService.addProduct(productDO);
    }

    @PutMapping("/product/{id}")
    public void updateProduct(@PathVariable Long id, @RequestBody Product product){
        productService.updateProduct(id,product);
    }

    @DeleteMapping("/product/{id}")
    public void delete(@PathVariable Long id){
        productService.deleteProduct(id);
    }
}
