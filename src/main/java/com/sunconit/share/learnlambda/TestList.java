package com.sunconit.share.learnlambda;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import org.apache.logging.log4j.util.Strings;
import org.springframework.util.StringUtils;

public class TestList {

  public static void main(String[] args) throws ParseException {

    ArrayList<Test> list = new ArrayList<>();
    Date today = new Date();
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat dfWeek = new SimpleDateFormat("EEEE");
    String week = dfWeek.format(today);
    System.out.println("今天星期：" + week);
    System.out.println("今天的日期："+df.format(today));
    String dayBeforeThree = df.format(new Date(today.getTime() - (long) 3 * 24 * 60 * 60 * 1000));
    System.out.println("三天前的日期：" + dayBeforeThree);
    Test test = new Test();
    test.setAnalyzeTimeIndex("2022-05-10");
    test.setAnalyzeValue("1000");
    Test test2 = new Test();
    test2.setAnalyzeTimeIndex("2022-05-11");
    test2.setAnalyzeValue("1000");
    Test test3 = new Test();
    test3.setAnalyzeTimeIndex("2022-05-05");
    test3.setAnalyzeValue("1000");
    list.add(test);list.add(test2);list.add(test3);
    System.out.println("补充前： "+list);


    List<String> collect1 = list.stream().sorted(Comparator.comparing(Test::getAnalyzeTimeIndex))
        .map(Test::getAnalyzeTimeIndex).collect(
            Collectors.toList());
    System.out.println(collect1);

    //获取最后天时间

    Date date = df.parse(collect1.get(collect1.size() - 1));
    System.out.println(" = :" +df.format(date));
    int COUNT = 7;
    for (int i = 1; i <= COUNT; i++) {
      String format = df.format(new Date(date.getTime() - (long) i * 24 * 60 * 60 * 1000));
      //不包含则补充添加
      if (!collect1.contains(format)){
        Test a = new Test();
        a.setAnalyzeTimeIndex(format);
        a.setAnalyzeValue("0");
        list.add(a);
        continue;
      }
    }
    list.sort(Comparator.comparing(Test::getAnalyzeTimeIndex));
    //删除最后一天
    list.remove(list.size()-1);
    System.out.println( " 补充后 :" + list);

    System.out.println(" ---  转为  星期 ---");
    for (int i = 0; i < list.size(); i++) {
      String weekToday = dfWeek.format(df.parse(list.get(i).getAnalyzeTimeIndex()));
      list.get(i).setAnalyzeTimeIndex(weekToday);
    }
    System.out.println(list);
  }


}

class Test{
  String analyzeTimeIndex;
  String analyzeValue;

  public Test(String analyzeTimeIndex, String analyzeValue) {
    this.analyzeTimeIndex = analyzeTimeIndex;
    this.analyzeValue = analyzeValue;
  }

  public Test() {
  }

  public String getAnalyzeTimeIndex() {
    return analyzeTimeIndex;
  }

  public void setAnalyzeTimeIndex(String analyzeTimeIndex) {
    this.analyzeTimeIndex = analyzeTimeIndex;
  }

  public String getAnalyzeValue() {
    return analyzeValue;
  }

  public void setAnalyzeValue(String analyzeValue) {
    this.analyzeValue = analyzeValue;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Test test = (Test) o;
    return Objects.equals(analyzeTimeIndex, test.analyzeTimeIndex) &&
        Objects.equals(analyzeValue, test.analyzeValue);
  }

  @Override
  public int hashCode() {
    return Objects.hash(analyzeTimeIndex, analyzeValue);
  }

  @Override
  public String toString() {
    return "Test{" +
        "analyzeTimeIndex='" + analyzeTimeIndex + '\'' +
        ", analyzeValue='" + analyzeValue + '\'' +
        '}';
  }
}