package com.sunconit.share.learnlambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class TestTwo {

  public static void main(String[] args) {
    ArrayList<String> list = new ArrayList<>(Arrays.asList("hello", "lambda", "hello", "stream","say"));
    Stream<String> stream = list.stream();
    //使用Stream.forEach()迭代,forEach()方法签名为void forEach(Consumer<? super E> action),
    //作用是对容器中的每个元素执行action指定的动作,也就是对元素进行遍历,forEach()是结束操作,代码会立即执行，输出所有字符串
    stream.forEach(str -> System.out.println(str));

    // Stream<T> filter(Predicate<? super T> predicate),返回一个只包含满足predicate条件元素的Stream,
    // filter()是个中间操作,如果只调用filter()不会有实际计算,因此也不会输出任何信息。
    stream.filter(str -> str.length() == 3)
        .forEach(str -> System.out.println(str));

    //Stream<T> distinct(),中间操作,返回一个去除重复元素之后的Stream
    stream.distinct()
        .forEach(str -> System.out.println(str));

    //排序函数有两个,一个是用自然顺序排序,一个是使用自定义比较器排序,函数原型分别为Stream<T>　sorted()和Stream<T>　
    // sorted(Comparator<? super T> comparator)
    stream.sorted((s1,s2)->s1.length()-s2.length())
        .forEach(System.out::println);
    stream.sorted().forEach(System.out::println);

    //<R> Stream<R> map(Function<? super T,? extends R> mapper),返回一个对当前所有元素执行执行mapper之后的结果组成的Stream
    //就是对每个元素按照某种操作进行转换，转换前后Stream中元素的个数不会改变，但元素的类型取决于转换之后的类型
    stream.map(str -> str.toUpperCase())
        .forEach(str -> System.out.println(str));

  }

}
