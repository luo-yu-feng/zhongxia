package com.sunconit.share.learnlambda;

import com.alibaba.fastjson.JSONObject;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;


public class Test3 {


  public static void main(String[] args) {
//    System.out.println(LocalDateTime.now());
//
//    LocalDateTime time = LocalDateTime
//        .of(LocalDate.now().with(TemporalAdjusters.firstDayOfMonth()), LocalTime.MIN);
//    System.out.println(time);
//
//    ArrayList<Integer> list = new ArrayList<>();
//    list.add(1);list.add(2);list.add(3);list.add(4);list.add(5);list.add(6);
//
//    ArrayList<Integer> listS = new ArrayList<>();
//    listS.add(1);listS.add(2);listS.add(3);
//
//    List<Integer> collect = list.stream().filter(i -> listS.contains(i))
//        .collect(Collectors.toList());
//    System.out.println(collect);


//    System.out.println(LocalDateTime
//        .of(LocalDate.now().with(TemporalAdjusters.firstDayOfMonth()), LocalTime.MIN));
//
//    System.out.println(LocalDateTime.now().plusDays(-30));
//
//    ArrayList<Object> list = new ArrayList<>();
//    Set<String> corpTypeSet = new HashSet<>();
//    System.out.println(CollectionUtils.isEmpty(list));System.out.println(CollectionUtils.isEmpty(corpTypeSet));
//     Calendar calendar = Calendar.getInstance();
//            int i = calendar.get(Calendar.YEAR);
//            calendar.clear();
//            calendar.set(Calendar.YEAR, i);
//            Date startDate = calendar.getTime();
//            Instant instant = startDate.toInstant();
//            ZoneId zoneId = ZoneId.systemDefault();
//            LocalDateTime startTime = instant.atZone(zoneId).toLocalDateTime();
//    System.out.println(startTime);
//
//    calendar.clear();
//    calendar.setTime(startDate);
//    calendar.add(Calendar.YEAR, 1);
//    Date endDate = calendar.getTime();
//    Instant instant1 = endDate.toInstant();
//    LocalDateTime endTime = instant1.atZone(zoneId).toLocalDateTime();
//    System.out.println(endTime);
//
//    BindTypeEnum typeEnumByCode = BindTypeEnum.getTypeEnumByCode("1");
//    System.out.println(typeEnumByCode.getCode());

//    System.out.println(LocalDateTime.now().format(
//        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
//    System.out.println(  LocalDateTime.now().plusDays(-7).format(
//        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
//
//    ArrayList<String> list = new ArrayList<>();
//    list.add("9");list.add("8");list.add("7");
//    System.out.println(list.toString());
//    System.out.println(String.valueOf(list));
//    System.out.println( StringUtils.join(list,","));
//    System.out.println(String.join(",",list));
////    List<List> lists = listSplit(2, list);
////    System.out.println(lists);
//
//    Map<String,Object> map0=new HashMap<String,Object>(){{put("a", "1");put("b", "2");}};
//    System.out.println(map0.get("c"));
//    System.out.println("柯桥区道交办".substring(0,2));
//    System.out.println(LocalDateTime.of(LocalDate.from(LocalDateTime.now().with(TemporalAdjusters.firstDayOfMonth())), LocalTime.MIN));

//    LocalDateTime time = LocalDateTime.of(2022, 9, 26, 12, 20,30);
//    System.out.println(time);
//    int minute = time.minusMinutes(4).getMinute();
//    int hour = time.minusMinutes(4).getHour();
//    minute = minute + hour*60;
//    System.out.println(minute/5 + 1 + "");
//
//    System.out.println(transSlicingToHourMinute(130,5));

    Random random = new Random();
    //随机产生0-9当中的一个随机整数
    int num = random.nextInt(10);
    System.out.println((int)(Math.random()*20+40));

    System.out.println(Math.random());



  }

  /**
   * @return java.lang.String
   * @Author zzy
   * @Description 将时间分片（以分钟划分的时间分片）转化为String的时间
   * @Date 11:13 上午 2020/12/2
   * @Param [slicing, size] 【时间分片序号，时间分片大小】
   **/
  public static String transSlicingToHourMinute(Integer slicing, Integer size) {
    Calendar calendar = Calendar.getInstance();
    calendar.set(Calendar.HOUR_OF_DAY, 0);
    calendar.set(Calendar.MINUTE, 0);
    calendar.set(Calendar.SECOND, 0);
    long time = (calendar.getTimeInMillis() + (slicing) * size * 60 * 1000);
    Date date = new Date(time);
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
    String dateString = simpleDateFormat.format(date);
    return dateString;
  }

  public static List<List> listSplit(int targetSize, List originalList) {
    List<List> resultList = new ArrayList<List>();
    if (originalList != null && !originalList.isEmpty()) {
      int listSize = originalList.size();
      if (targetSize <= 0) {
        targetSize = 1000;
      }
      if (listSize > targetSize) {
        //需要分组
        int flag = 0;//满targetSize判断
        int i = 0;//满遍历判断
        List<Object> tempList = new ArrayList<Object>();
        for (Object object : originalList) {
          i++;
          tempList.add(object);
          flag++;
          if (flag == targetSize) {
            //达到目标规模则收集
            List<Object> tempListGroup = new ArrayList<Object>();
            tempListGroup.addAll(tempList);
            resultList.add(tempListGroup);
            tempList.clear();
            flag = 0;
          } else if (i == originalList.size()) {
            //全部遍历完
            resultList.add(tempList);
          }
        }
      } else {
        resultList.add(originalList);
      }
    } else {
      //传入list为空直接返回null
      resultList = null;
    }
    return resultList;
  }

}
