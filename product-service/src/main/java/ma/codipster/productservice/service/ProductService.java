package ma.codipster.productservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.codipster.productservice.dto.product.ProductRequest;
import ma.codipster.productservice.dto.product.ProductResponse;
import ma.codipster.productservice.mappers.ProductMapper;
import ma.codipster.productservice.model.Product;
import ma.codipster.productservice.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    private final ProductMapper productMapper;


    public void createProduct(ProductRequest productRequest) {

        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice()).build();

        productRepository.save(product);
        log.info("Product created successfully");
    }

    public void updateProduct(ProductRequest productRequest, String id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        product.setName(productRequest.getName());
        product.setDescription(productRequest.getDescription());
        product.setPrice(productRequest.getPrice());
        productRepository.save(product);
        log.info("Product updated successfully");
    }

    public void deleteProduct(String id) {
        productRepository.deleteById(id);
        log.info("Product deleted successfully");
    }

    public ProductResponse getProductById(String id) {
        return productMapper.productToProductResponse(productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found")));
    }

    public List<ProductResponse> getAllProducts() {
        return productMapper.productToProductResponse(productRepository.findAll());
    }


}