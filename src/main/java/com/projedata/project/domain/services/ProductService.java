package com.projedata.project.domain.services;
import com.projedata.project.domain.model.Product;
import com.projedata.project.domain.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public Product create(Product product){
        return productRepository.save(product);
    }

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public Product findById(Long id){
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product Not Found"));
    }

    public Product update(Long id, Product updateProduct){
        Product product = findById(id);
        product.setName(updateProduct.getName());
        product.setPrice(updateProduct.getPrice());

        return productRepository.save(product);

    }

    public void deleteProduct(Long id){
        Product product = findById(id);
        productRepository.delete(product);
    }


}
