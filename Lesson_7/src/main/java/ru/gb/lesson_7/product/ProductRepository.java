package ru.gb.lesson_7.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {


    List<Product> findAllByPriceLessThanEqualOrderByPriceDesc(int max);

    List<Product> findAllByPriceGreaterThanEqualOrderByPrice(int min);

    List<Product> findAllByPriceBetweenOrderByPrice(int min, int max);
}



