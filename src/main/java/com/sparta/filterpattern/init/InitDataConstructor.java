package com.sparta.filterpattern.init;

import jakarta.annotation.PostConstruct;
import jakarta.servlet.Filter;
import org.springframework.transaction.annotation.Transactional;

/**
 * create on 2024/05/16 create by IntelliJ IDEA.
 *
 * <p> New Project. </p>
 *
 * @author HoChan Son (hcson)
 * @version 1.0
 * @since 1.0
 */
public class InitDataConstructor {

  @PostConstruct
  @Transactional
  public void init() {

  }

}
