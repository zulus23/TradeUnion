package ru.zhukov.tradeunion;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.Assert.assertTrue;

public class TestBCryptPasswordEncoder {

  @Test
  public void decodePassword(){
      BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
      String result = encoder.encode("password");
      System.out.println("result = " + result);
      assertTrue(encoder.matches("password", result));
  }
}
