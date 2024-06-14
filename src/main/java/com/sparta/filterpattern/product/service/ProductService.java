package com.sparta.filterpattern.product.service;

import com.sparta.filterpattern.product.filter.ProductCategoryFilter;
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

  /**
   * 전체 찾기.
   *
   * @return 조회된 상품
   */
  public List<Product> findAll() {
    return repository.findAll()
        .stream()
        .filter(p -> filter.check(p)) // 해당 필터를 통해서 true 만을 리턴 해줍니다.
        .toList();

  }

  private ProductFilter initFilter() {
    // 품절 여부 필터 등록
    ProductFilter productFilter = new ProductSoldYnFilter();

    // 카테고리 필터
    return productFilter.add(new ProductCategoryFilter());
  }
}
