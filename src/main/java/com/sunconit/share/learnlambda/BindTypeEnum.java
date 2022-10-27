package com.sunconit.share.learnlambda;

/**
 * @author  刘云飞
 * @description IP配置类型枚举类
 * @date 2022-07-13
 */
public enum BindTypeEnum {
  /**
   *  单个IP
   */
  SINGLE("单个","1"),

  /**
   * 多个IP
   */
  MULTIPLE("多个","2"),

  /**
   * IP段
   */
  SCOPE("IP段","3");

  private final String name;

  private final String code;

  BindTypeEnum(String name,String code) {
    this.name = name;
    this.code = code;
  }

  public String getName() {
    return name;
  }

  public String getCode() {
    return code;
  }

  public static BindTypeEnum getTypeEnumByCode(String code) {
      for (BindTypeEnum type : BindTypeEnum
          .values()) {
        if (type.getCode().equals(code)) {
          return type;
        }
      }
      return null;
    }


}
