package com.sunconit.share.learnlambda;


import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TestThree {

  public static void main(String[] args) {
    //从一组单词中找出最长的单词
    ArrayList<String> list = new ArrayList<>(
        Arrays.asList("hello", "lambda", "hey", "stream","say"));
    Stream<String> stream = list.stream();
//    Optional<String> s = stream.reduce((s1, s2) -> s1.length() >= s2.length() ? s1 : s2);
//    System.out.println(s.get());
//    System.out.println(stream.max((s1,s2) -> s1.length() -s2.length()).get());



    //求单词长度之和
//    Stream<String> stringStream = Stream.of("this", "is", "stream");
//    Integer integer = stringStream.reduce(0, (sum, str) -> sum + str.length(), (a, b) -> a + b);
//    System.out.println(integer);
//
//    int integer = stringStream.mapToInt(str -> str.length()).sum();
//    System.out.println(integer);

    // 将Stream转换成容器或Map
//    List<String> list1 = stream.collect(Collectors.toList());
//    Set<String> set = stream.collect(Collectors.toSet());
//    Map<String, Integer> map = stream.collect(Collectors.toMap(Function.identity(), String::length)); // (3)
//    System.out.println(list1);
//    System.out.println(set);
//    System.out.println(map);

    //　将Stream规约成List
//    Stream<String> stream = Stream.of("this", "is", "stream");
//    ArrayList<Object> list = stream.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
//    List<String> listCollector = stream.collect(Collectors.toList());
//    // 使用toCollection()指定规约容器的类型
//    ArrayList<String> collect = stream.collect(Collectors.toCollection(ArrayList::new));
//    System.out.println(list);
//    System.out.println(listCollector);

    IntStream.range(1, 10)
        .peek(x -> System.out.print("\nA" + x))
        .limit(3)
        .peek(x -> System.out.print("B" + x))
        .forEach(x -> System.out.print("C" + x));

  }

}
