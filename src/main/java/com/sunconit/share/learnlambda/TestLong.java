package com.sunconit.share.learnlambda;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

public class TestLong {

  public static void main(String[] args) {
    LocalDateTime now = LocalDateTime.now();
    LocalDateTime of = LocalDateTime.of(now.toLocalDate(), LocalTime.MIN);
    LocalDateTime localDateTime = of.plusDays(-7);
    System.out.println(localDateTime);
  }
}
