package com.sunconit.share.redis;//package com.supconit.its.itp.filter;
//
//import com.supconit.its.itp.constant.Constant;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.connection.Message;
//import org.springframework.data.redis.connection.MessageListener;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.stereotype.Component;
//
///**
// * @author 刘云飞
// * @description redis 监听类
// */
//@Component
//public class RedisMessageListener implements MessageListener {
//
//
//  @Autowired
//  private RedisTemplate<String, String> redisTemplate;
//
//  @Override
//  public void onMessage(Message message, byte[] bytes) {
//    System.out.println("key发生变化===》" + message);
//    String videoPoint = redisTemplate.opsForValue().get(Constant.VIDEO_POINT);
//    System.out.println("视频采集点变更为: " + videoPoint);
//    String vehiclePoint = redisTemplate.opsForValue().get(Constant.VEHICLE_POINT);
//    System.out.println("过车采集点变更为: " + vehiclePoint);
//  }
//
//
//
//}
