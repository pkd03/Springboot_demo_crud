package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repo;

    public List<Product> getAll() {
        return repo.findAll();
    }

    public Product getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Product create(Product p) {
        return repo.save(p);
    }

    public Product update(Long id, Product newData) {
        return repo.findById(id)
            .map(p -> {
                p.setName(newData.getName());
                p.setPrice(newData.getPrice());
                p.setDescription(newData.getDescription());
                return repo.save(p);
            }).orElse(null);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
