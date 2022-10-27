package com.sunconit.share.learnlambda;

import com.alibaba.fastjson.JSON;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.SimpleFormatter;

public class RandomTest {

  public static void main(String[] args) {
    String s = "{\"status\":true,\"code\":\"10000\",\"msg\":\"ok\",\"data\":{\"root\":[{\"id\":2,\"sn\":\"81-00-29-70-03-68-09-03\",\"nmsId\":747,\"networkType\":\"直连\",\"version\":\"v4.50.13\",\"manufacture\":\"不详\",\"deviceTpye\":\"RFID\",\"CODE\":null,\"ip\":\"11.12.10.10\",\"STATUS\":1,\"\"monitorName\":\"所有设备\",\"region\":\"大足区\",\"\"stationCode\":project\":\"大足区\",\"traffic_police\":\"502500000000\",\"regionCode\":\"500225\",\"stationType\":\"路面\",\"\"50022500000102\",\"directionName\":\"宏运商业城往区政府方向\",\"networkTime\":null,\"carrier\":\"大足电信\",\"vlanNumber\":\"100\",\"latitude\":\"29.706285\",\"longitude\":\"105.738173\",\"availableIp\":\"\"}]}}";
    Map<Object,Object> mapType = JSON.parseObject(s, Map.class);
    for (Object obj : mapType.keySet()){
      System.out.println("key为："+obj+"值为："+mapType.get(obj));
    }
  }
}
