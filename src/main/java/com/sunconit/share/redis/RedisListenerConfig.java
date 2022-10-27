//package com.supconit.its.itp.config;
//
//import com.supconit.its.itp.constant.Constant;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Properties;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.MessageListener;
//import org.springframework.data.redis.connection.RedisConnection;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.listener.PatternTopic;
//import org.springframework.data.redis.listener.RedisMessageListenerContainer;
//import org.springframework.data.redis.listener.Topic;
//import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
//import org.springframework.util.StringUtils;
//
//@Configuration
//public class RedisListenerConfig {
//
//  @Autowired
//  private RedisTemplate redisTemplate;
//
//  //redis连接工厂
//  @Autowired
//  private RedisConnectionFactory connectionFactory;
//
//  //redis 消息监听器
//  @Autowired
//  private MessageListener redisMsgListener;
//
//  //任务池
//  private ThreadPoolTaskScheduler taskScheduler;
//
//  /**
//   * @Description 创建任务池, 运行线程等待处理redis消息
//   * @Param []
//   * @Return org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler
//   * @Author 刘云飞
//   * @Date 2022-03-17
//   */
//  @Bean
//  public ThreadPoolTaskScheduler iniTaskScheduler() {
//    if (taskScheduler != null) {
//      return taskScheduler;
//    }
//    taskScheduler = new ThreadPoolTaskScheduler();
//    taskScheduler.setPoolSize(20);
//    return taskScheduler;
//  }
//
//  //指定监听redis的数据库和key
//  private static final Topic TOPIC_VIDEO_NAME = new PatternTopic("__keyspace@6__:"+ Constant.VIDEO_POINT);
//  private static final Topic TOPIC_VEHICLE_NAME = new PatternTopic("__keyspace@6__:"+Constant.VEHICLE_POINT);
//  private static List<Topic> list = new ArrayList<>(Arrays.asList(TOPIC_VIDEO_NAME,TOPIC_VEHICLE_NAME));
//  //配置模式 ：KEA 监听所有事件
//  private String keyspaceNotificationsConfigParameter = "KEA";
//  /**
//   * @Description 定义Redis的监听容器
//   * @Param []
//   * @Return org.springframework.data.redis.listener.RedisMessageListenerContainer
//   * @Author 刘云飞
//   * @Date 2022-03-17
//   */
//  @Bean
//  public RedisMessageListenerContainer initAndSetRedisConfig() {
//    RedisMessageListenerContainer container = new RedisMessageListenerContainer();
//    container.setConnectionFactory(connectionFactory);
//    container.setTaskExecutor(iniTaskScheduler());
//    if (StringUtils.hasText(keyspaceNotificationsConfigParameter)) {
//      RedisConnection connection = container.getConnectionFactory().getConnection();
//      //默认事件通知为关闭状态,修改redis.conf配置,只针对当前进程有效,redis重启失效
//      try {
//        Properties config = connection.getConfig("notify-keyspace-events");
//        if (!StringUtils.hasText(config.getProperty("notify-keyspace-events"))) {
//          connection.setConfig("notify-keyspace-events", keyspaceNotificationsConfigParameter);
//        }
//      } finally {
//        connection.close();
//      }
//    }
//    // 注册消息监听
//    container.addMessageListener(redisMsgListener, list);
//    return container;
//  }
//
//}
