package com.sparta.filterpattern.product.filter;

import com.sparta.filterpattern.product.model.Product;
import com.sparta.filterpattern.product.model.YN;

/**
 * create on 2024/05/16 create by IntelliJ IDEA.
 *
 * <p> 삼품의 품절을 체크하는 filter. </p>
 *
 * @author HoChan Son (hcson)
 * @version 1.0
 * @since 1.0
 */
public class ProductSoldYnFilter extends ProductFilter {

  @Override
  public boolean check(Product product) {
    // 품절인지 체크.
    if (YN.Y == product.getSoldYn()) {
      return false;
    }

    // 다음 필터 조건 체크
    return checkNext(product);
  }
}
