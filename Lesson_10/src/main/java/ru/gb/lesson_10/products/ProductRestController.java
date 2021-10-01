package ru.gb.lesson_10.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/products")
public class ProductRestController {
    private ProductRepository productRepository;

    @Autowired
    public void setProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(optionalProduct.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProductById(@PathVariable Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        productRepository.deleteById(id);
        return new ResponseEntity<>("Product id=" + id + " has been removed", HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        product.setId(0L);
        Product createdProduct = productRepository.save(product);
        return ResponseEntity.created(URI.create("/products/" + createdProduct.getId())).body(createdProduct);
    }

    @PutMapping(consumes = (MediaType.APPLICATION_JSON_VALUE))
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        Product updatedProduct = productRepository.save(product);
        return ResponseEntity.created(URI.create("/products/" + updatedProduct.getId())).body(updatedProduct);
    }

}
