package com.projetsweb.dscomerce.services;

import com.projetsweb.dscomerce.dtos.ProductDTO;
import com.projetsweb.dscomerce.entities.Product;
import com.projetsweb.dscomerce.repositories.ProductRepository;
import com.projetsweb.dscomerce.services.exceptions.DatabaseException;
import com.projetsweb.dscomerce.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = true)
    public Page<ProductDTO> findAll(Pageable pageable) {
        Page<Product> products = productRepository.findAll(pageable);
        return products.map(ProductDTO::new);
    }

    @Transactional(readOnly = true)
    public ProductDTO findById(Long id) {

        Product result = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found."));
        return new ProductDTO(result);
    }

    @Transactional
    public ProductDTO insert(ProductDTO dto) {

        Product product = new Product();

        product.setDescription(dto.getDescription());
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        product.setImgUrl(dto.getImgUrl());

        product = productRepository.save(product);
        return new ProductDTO(product);
    }

    @Transactional
    public ProductDTO update(Long id, ProductDTO dto) {

        try {
            Product product = productRepository.getReferenceById(id);

            product.setName(dto.getName());
            product.setDescription(dto.getDescription());
            product.setPrice(dto.getPrice());
            product.setImgUrl(dto.getImgUrl());

            product = productRepository.save(product);
            return new ProductDTO(product);
        } catch (EntityNotFoundException e) {

            throw new ResourceNotFoundException("Recurso não encontrado.");
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {

        if(!productRepository.existsById(id)) {

            throw new ResourceNotFoundException("Recurso não encontrado");
        }

        try {
            productRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {

            throw new DatabaseException("Tentativa de violação de integridade.");
        }
    }
}
