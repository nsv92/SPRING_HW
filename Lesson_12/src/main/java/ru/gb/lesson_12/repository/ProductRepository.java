package ru.gb.lesson_12.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.gb.lesson_12.entity.Product;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {

}
