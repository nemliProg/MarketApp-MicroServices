package ma.codipster.productservice.controller;

import lombok.RequiredArgsConstructor;
import ma.codipster.productservice.dto.product.ProductRequest;
import ma.codipster.productservice.dto.product.ProductResponse;
import ma.codipster.productservice.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getProducts(){
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable String id){
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @PostMapping
    public ResponseEntity<Void> createProduct(@RequestBody ProductRequest productRequest){
        productService.createProduct(productRequest);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateProduct(@RequestBody ProductRequest productRequest, @PathVariable String id){
        productService.updateProduct(productRequest, id);
        return ResponseEntity.ok().build();
    }

}
