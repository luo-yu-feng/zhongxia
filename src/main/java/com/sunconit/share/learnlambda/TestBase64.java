package com.sunconit.share.learnlambda;

import java.util.Base64;

public class TestBase64 {

  public static void main(String[] args) {
    String userName = "admin2021";
    String password = "CQsa@2021";
    String name = Base64.getEncoder().encodeToString(userName.getBytes());
    String word = Base64.getEncoder().encodeToString(password.getBytes());
    System.out.println(name);
    System.out.println(word);
    System.out.println(new String(Base64.getDecoder().decode(name)));
  }
}
