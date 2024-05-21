package com.sparta.filterpattern.product.controller;

import com.sparta.filterpattern.product.model.Product;
import com.sparta.filterpattern.product.service.ProductService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * create on 2024/05/20 create by IntelliJ IDEA.
 *
 * <p> New Project. </p>
 *
 * @author HoChan Son (hcson)
 * @version 1.0
 * @since 1.0
 */
@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

  private final ProductService service;

  /**
   * findAll.
   *
   * @return products.
   */
  @GetMapping
  public ResponseEntity<List<Product>> findAll() {
    return ResponseEntity.ok(
        service.findAll()
    );
  }
}
