package com.example.EcommerceApp.Service;

import com.example.EcommerceApp.DAO.ProductDO;
import com.example.EcommerceApp.Model.Categories;
import com.example.EcommerceApp.Model.Product;
import com.example.EcommerceApp.Repository.EcommCategoryRepository;
import com.example.EcommerceApp.Repository.EcommProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private EcommProductRepository ecommProductRepository;

    @Autowired
    private EcommCategoryRepository ecommCategoryRepository;

    public List<Product> getAllProducts() {
        return ecommProductRepository.findAll();
    }

    public Product getProductbyId(Long id){
        return ecommProductRepository.findById(id).orElse(null);
    }

    public void addProduct(ProductDO productDO){
        Product product = new Product();
        product.setName(productDO.getName());
        product.setDescription(productDO.getDescription());
        product.setPrice(productDO.getPrice());
        product.setQuantity(productDO.getQuantity());
        product.setWeight(productDO.getWeight());
        Categories category = ecommCategoryRepository.findById(productDO.getCategoryId()).orElse(null);
        product.setCategory(category);
        ecommProductRepository.save(product);
    }

    public void deleteProduct(Long id){
        ecommProductRepository.deleteById(id);
    }

    public void updateProduct(Long id, Product product){
        Product oldProduct = getProductbyId(id);
        if(oldProduct != null){
            oldProduct.setName(product.getName());
            oldProduct.setDescription(product.getDescription());
            oldProduct.setPrice(product.getPrice());
            oldProduct.setWeight(product.getWeight());
            oldProduct.setQuantity(product.getQuantity());
            ecommProductRepository.save(oldProduct);
        }
    }

    public Page<Product> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection){
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending(): Sort.by(sortField).descending();
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return ecommProductRepository.findAll(pageable);
    }
}

