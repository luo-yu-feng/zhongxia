package com.sunconit.share.learnlambda;

public class IpUtil {
  /*验证IP是否属于某个IP段

   *

   * ipSection    IP段（以'-'分隔）

   * ip           所验证的IP号码

   *

   */

  public static boolean ipExistsInRange(String ip,String ipSection) {
    ipSection = ipSection.trim();
    ip = ip.trim();
    int idx = ipSection.indexOf('-');
    String beginIP = ipSection.substring(0, idx);
    String endIP = ipSection.substring(idx + 1);
    long ip2long = getIp2long(ip);
    long beginIP2long = getIp2long(beginIP);
    long endIP2long = getIp2long(endIP);
    //判断是否在范围内
    if (beginIP2long>=ip2long){
      if (endIP2long <= ip2long){
        return true;
      }else {
        return false;
      }
    }else {
      if (endIP2long <= ip2long){
        return false;
      }else {
        return true;
      }
    }
  }

  public static long getIp2long(String ip) {
    ip = ip.trim();
    String[] ips = ip.split("\\.");
    long ip2long = 0L;
    for (int i = 0; i < 4; ++i) {
      ip2long = ip2long << 8 | Integer.parseInt(ips[i]);
    }
    return ip2long;
  }

  public static long getIp2long2(String ip) {
    ip = ip.trim();
    String[] ips = ip.split("\\.");
    long ip1 = Integer.parseInt(ips[0]);
    long ip2 = Integer.parseInt(ips[1]);
    long ip3 = Integer.parseInt(ips[2]);
    long ip4 = Integer.parseInt(ips[3]);
    long ip2long =1L* ip1 * 256 * 256 * 256 + ip2 * 256 * 256 + ip3 * 256 + ip4;
    return ip2long;

  }

  public static void main(String[] args){

    //10.10.10.116 是否属于固定格式的IP段10.10.1.00-10.10.255.255

    String ip="192.168.1.127";

    String ipSection="192.179.2.64-192.167.3.28";

    boolean exists=ipExistsInRange(ip,ipSection);

    System.out.println(exists);

    System.out.println(getIp2long(ip));

    System.out.println(getIp2long2(ip));

  }
}
