package ru.gb.lesson_10.carts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

    @Override
    Optional<Cart> findById(Long id);

    @Override
    List<Cart> findAll();

    @Override
    void deleteById(Long id);

//    Cart addProductById(Long id);
}
