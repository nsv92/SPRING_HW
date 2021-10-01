package ru.gb.lesson_10.carts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/carts")
public class CartRestController {
    private final CartRepository cartRepository;

    @Autowired
    public CartRestController(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @GetMapping
    public ResponseEntity<List<Cart>> getAllCarts() {
        return ResponseEntity.ok(cartRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cart> getCartById(@PathVariable Long id) {
        Optional<Cart> optionalCart = cartRepository.findById(id);
        if (optionalCart.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(optionalCart.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCartById(@PathVariable Long id) {
        Optional<Cart> optionalCart = cartRepository.findById(id);
        if (optionalCart.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        cartRepository.deleteById(id);
        return new ResponseEntity<>("Cart id=" + id + " has been removed", HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Cart> addCart(@RequestBody Cart cart) {
        Cart createdCart = cartRepository.save(cart);
        return ResponseEntity.created(URI.create("/carts/" + createdCart.getId())).body(createdCart);
    }

    @PutMapping(consumes = (MediaType.APPLICATION_JSON_VALUE))
    public ResponseEntity<Cart> updateCart(@RequestBody Cart cart) {
        Cart updatedCart = cartRepository.save(cart);
        return ResponseEntity.created(URI.create("/carts/" + updatedCart.getId())).body(updatedCart);
    }


}
