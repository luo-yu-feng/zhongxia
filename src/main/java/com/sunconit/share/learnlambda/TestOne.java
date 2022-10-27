package com.sunconit.share.learnlambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class TestOne {

  public static void main(String[] args) {
    // 匿名内部类写法
//    new Thread(new Runnable() {
//      @Override
//      public void run() {
//        System.out.println(" hello ");
//      }
//    }
//    ).start();
//    System.out.println(" Tradition ");

    //lambda表达式
//    new Thread(() -> {
//      System.out.println(" hey ");
//      System.out.println(" lambda ");
//    }).start();

    System.out.println("=======================");

    //打印长度大于三的字符串
    ArrayList<String> list = new ArrayList<>(Arrays.asList("hello", "lambda", "hi", "stream"));
    //for循环
    for (String str : list) {
      if (str.length() > 3){
        System.out.println(str);
      }
    }
    System.out.println("=======================");
    //foreach()结合匿名内部类
    list.forEach(new Consumer<String>() {
      @Override
      public void accept(String s) {
        if (s.length() > 3){
          System.out.println(s);
        }
      }
    });
    System.out.println("=======================");
    //foreach()结合lambda
    list.forEach(str ->{
      System.out.println(str);
    });
  }
}
