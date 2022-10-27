package com.sunconit.share.learnlambda;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.swing.tree.TreeNode;
import org.apache.commons.lang3.StringUtils;

public class IpTest {

    public static void main(String[] args) {
      ArrayList<Long> longs = new ArrayList<>();
      longs.add(0L);longs.add(1L);
      System.out.println(longs);
      String s = StringUtils.join( longs,",");
      System.out.println("ss " + s);
      List<String> list = Arrays.asList(s.split(","));
      System.out.println(list);

    }

  public static boolean isFlipedString(String s1, String s2) {
    if(s1.length() != s2.length()){
      return false;
    }
    if((s2+s2).contains(s1)){
      return true;
    }else{
      return false;
    }

  }

  public static  int[] twoSum(int[] nums, int target) {
    List<Integer> collect = Arrays.stream(nums).boxed().collect(Collectors.toList());
    int[] result = null;
    for (int i = 0; i < collect.size(); i++) {
      if (collect.contains(target-collect.get(i))){
        if (collect.size() == 2){
          return new int[]{0,1};
        }else {
          for (int j = 0; j < collect.size(); j++) {
            if (collect.get(j) == target-collect.get(i)){
              if (i != j){
                return new int[]{i,j};
              }
            }
          }
        }
      }
    }
    return result;
  }

  public static boolean isSymmetric(TreeNode root) {
      Boolean result =true;
      if (root.getChildCount()%2 !=0 || root.getIndex(null)>-1){
        result = false;
      }else {
        String s = root.toString();
        result = true;
      }
      return result;
  }


    public static boolean isInRangeTest(String ip, String cidr) {
      // 以'.'为分隔拆分IP地址存入字符串数组ips
      String[] ips = ip.split("\\.");
      // 通过移位和或运算把IP地址由字符串数组转化为整数
      int ipAddr = (Integer.parseInt(ips[0]) << 8) | (Integer.parseInt(ips[1]) << 8)
          | (Integer.parseInt(ips[2]) << 8) | (Integer.parseInt(ips[3]));
      // 取出指定网段的子网掩码,即'/'后的数字,此为CIDR斜线记法
//      int type = Integer.parseInt(cidr.replaceAll(".*-", ""));
//      // 转化为整数表示
//      int mask = 0xFFFFFFFF << (32 - type);
      // 取出子网IP
      String[] netIps = cidr.replaceAll("-.*", "").split("\\.");
      // 通过移位和或运算把子网IP由字符串数组转化为整数
      int netAddr = (Integer.parseInt(netIps[0]) <<8) | (Integer.parseInt(netIps[1]) << 8)
          | (Integer.parseInt(netIps[2]) << 8) | (Integer.parseInt(netIps[3]));
      String[] endIps = cidr.replaceAll(".*-", "").split("\\.");
      int endAddr = (Integer.parseInt(endIps[0]) << 8) | (Integer.parseInt(endIps[1]) << 8)
          | (Integer.parseInt(endIps[2]) << 8) | (Integer.parseInt(endIps[3]));
      // 两个IP分别与掩码做与运算,结果相等则返回True
      return (ipAddr & endAddr) == (netAddr & endAddr);

    }

  public static boolean isInRange(String ip, String cidr) {
    // 以'.'为分隔拆分IP地址存入字符串数组ips
    String[] ips = ip.split("\\.");
    // 通过移位和或运算把IP地址由字符串数组转化为整数
    int ipAddr = (Integer.parseInt(ips[0]) << 24) | (Integer.parseInt(ips[1]) << 16)
        | (Integer.parseInt(ips[2]) << 8) | (Integer.parseInt(ips[3]));
    // 取出指定网段的子网掩码,即'/'后的数字,此为CIDR斜线记法
    int type = Integer.parseInt(cidr.replaceAll(".*/", ""));
    // 转化为整数表示
    int mask = 0xFFFFFFFF << (32 - type);
    // 取出子网IP
    String[] netIps = cidr.replaceAll("/.*", "").split("\\.");
    // 通过移位和或运算把子网IP由字符串数组转化为整数
    int netAddr = (Integer.parseInt(netIps[0]) << 24) | (Integer.parseInt(netIps[1]) << 16)
        | (Integer.parseInt(netIps[2]) << 8) | (Integer.parseInt(netIps[3]));
    // 两个IP分别与掩码做与运算,结果相等则返回True
    return (ipAddr & mask) == (netAddr & mask);

  }


}
