package ru.gb.lesson_9.products;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ProductService extends JpaRepository<Product, Long> {

    Optional<Product> findById(Long id);

    @Override
    List<Product> findAll();

    void deleteById(Long id);


}
