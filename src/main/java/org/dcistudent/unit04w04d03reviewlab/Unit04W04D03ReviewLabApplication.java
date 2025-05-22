package org.dcistudent.unit04w04d03reviewlab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class Unit04W04D03ReviewLabApplication {

  public static void main(String[] args) {
    SpringApplication.run(Unit04W04D03ReviewLabApplication.class, args);
  }

}
