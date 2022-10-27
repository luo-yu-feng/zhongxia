package com.sunconit.share.learnlambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.Data;


public class TestGreoup {

  public static void main(String[] args) {
    User user1 = new User("zhangsan", "beijing", 10);
    User user2 = new User("zhangsan", "beijing", 20);
    User user3 = new User("lisi", "shanghai", 30);
    List<User> list = new ArrayList<User>();
    list.add(user1);
    list.add(user2);
    list.add(user3);
    Map<String, Map<String, List<User>>> collect
        = list.stream().collect(
        Collectors.groupingBy(
            User::getAddress, Collectors.groupingBy(User::getName)
        )
    );
    System.out.println(collect);
  }

  @Data
  static class User{
    public String Name;
    public String address;
    public Integer age;

    public User(String zhangsan, String beijing, int i) {

    }
  }

}
