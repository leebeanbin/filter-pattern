package com.sparta.filterpattern.product.filter;

import com.sparta.filterpattern.product.model.Product;
import lombok.NonNull;

/**
 * create on 2024/05/16 create by IntelliJ IDEA.
 *
 * <p> 상품 필터조건. </p>
 *
 * @author HoChan Son (hcson)
 * @version 1.0
 * @since 1.0
 */
public abstract class ProductFilter {

  /**
   * 다음 검사할 filter.
   */
  private ProductFilter next;


  /**
   * Filter 를 생성하는 static method.
   *
   * @param first 첫번째
   * @param chain 다음 chain[]
   * @return header 값.
   */
  public static ProductFilter initAll(@NonNull ProductFilter first, ProductFilter... chain) {
    ProductFilter head = first;

    for (ProductFilter next : chain) {
      head.add(next);
    }

    return head;
  }

  /**
   * 필터 정보를 체크한다.
   *
   * @param product 체크할 상품
   * @return 체크 유무.
   */
  public abstract boolean check(Product product);

  /**
   * 다음 필터 조건을 체크.
   *
   * @param product 체크할 상품.
   * @return 체크 유무
   */
  protected boolean checkNext(@NonNull Product product) {
    if (this.next == null) {
      return true;
    }
    return this.next.check(product);
  }

  /**
   * 끝에 추가한다. 그렇기에 시간 복잡도가 O(n) 인데 수정하기 귀찮다.
   *
   * @param filter 추가할 필터.
   * @return 필터정보.
   */
  public ProductFilter add(ProductFilter filter) {
    if (filter == null) {
      return this;
    }

    ProductFilter head = this;

    while (head.next != null) {
      head = head.next;
    }

    head.next = filter;
    return this;
  }
}
