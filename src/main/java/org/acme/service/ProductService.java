package org.acme.service;
import org.acme.dto.ProductDTO;
import org.acme.entity.ProductEntity;
import org.acme.repository.ProductRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;


@ApplicationScoped
public class ProductService {


    @Inject //para injetar dependencia
    private ProductRepository productRepository;

    public List<ProductDTO> findAllProducts() {

        List<ProductDTO> products = new ArrayList<>();

        productRepository.findAll().stream().forEach(item -> {
            products.add(mapProductEntityToDTO(item));
        });

        return products;
    }

    public ProductDTO getProductById(Long id) {

        return mapProductEntityToDTO(productRepository.findById(id));
    }
    public void createNewProduct(ProductDTO productDTO){
        productRepository.persist(mapProductDTOToEntity(productDTO));
    }

    public void changeProduct(Long id, ProductDTO productDTO){
        ProductEntity productEntity = productRepository.findById(id);
        productEntity.setName(productDTO.getName());
        productEntity.setDescription(productDTO.getDescription());
        productEntity.setCategory(productDTO.getCategory());
        productEntity.setModel(productDTO.getModel());
        productEntity.setPrice(productDTO.getPrice());

        productRepository.persist(productEntity);
    }

    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }

    private ProductDTO mapProductEntityToDTO(ProductEntity productEntity){
        ProductDTO product = new ProductDTO();

        product.setName(productEntity.getName());
        product.setCategory(productEntity.getCategory());
        product.setDescription(productEntity.getDescription());
        product.setModel(productEntity.getModel());
        product.setPrice(productEntity.getPrice());

        return product;
    }

    private ProductEntity mapProductDTOToEntity(ProductDTO productDTO){
        ProductEntity product = new ProductEntity();

        product.setName(productDTO.getName());
        product.setCategory(productDTO.getCategory());
        product.setDescription(productDTO.getDescription());
        product.setModel(productDTO.getModel());
        product.setPrice(productDTO.getPrice());

        return product;
    }



}
