package com.sparta.filterpattern.product.service;

import com.sparta.filterpattern.product.filter.ProductFilter;
import com.sparta.filterpattern.product.filter.ProductSoldYnFilter;
import com.sparta.filterpattern.product.model.Product;
import com.sparta.filterpattern.product.repository.ProductRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * create on 2024/05/16 create by IntelliJ IDEA.
 *
 * <p> New Project. </p>
 *
 * @author HoChan Son (hcson)
 * @version 1.0
 * @since 1.0
 */
@Service
@RequiredArgsConstructor
public class ProductService {

  private final ProductRepository repository;

  private final ProductFilter filter = initFilter();

  public Product save(Product product) {
    return repository.save(product);
  }

  public List<Product> findAll(Product product) {
    return repository.findAll()
        .stream()
        .filter(p -> filter.check(p))
        .toList();

  }

  private ProductFilter initFilter() {
    ProductFilter productFilter = new ProductSoldYnFilter();
    return productFilter;
  }

}
