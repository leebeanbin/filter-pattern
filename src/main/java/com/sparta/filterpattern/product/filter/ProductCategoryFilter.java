package com.sparta.filterpattern.product.filter;

import com.sparta.filterpattern.product.model.Category;
import com.sparta.filterpattern.product.model.Product;

/**
 * create on 2024/05/27 create by IntelliJ IDEA.
 *
 * <p> New Project. </p>
 *
 * @author HoChan Son (hcson)
 * @version 1.0
 * @since 1.0
 */
public class ProductCategoryFilter extends ProductFilter {

  @Override
  public boolean check(Product product) {
    if (Category.ACCESSORY == product.getCategory()) {
      return false;
    }

    return checkNext(product);
  }
}
