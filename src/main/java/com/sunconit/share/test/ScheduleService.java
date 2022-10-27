package com.sunconit.share.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class ScheduleService  implements SchedulingConfigurer {

  private String cron = "*/5 * * * * *";
  private Integer i = 3;

  private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

  @Override
  public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
    //方法1 动态使用cron表达式设置循环间隔
    taskRegistrar.addTriggerTask(new Runnable() {
      @Override
      public void run() {
        System.out.println(format.format(new Date()) + "============1111111111111111111111========="+cron);
      }
    }, new Trigger() {
      @Override
      public Date nextExecutionTime(TriggerContext triggerContext) {
        //此处使用CronTrigger触发器，可动态修改cron表达式来操作循环规则，
        //但是具体使用受制于cron表达式的规范，不能做到随心所欲设置循环间隔时间
        //修改为10s
        if (i > 2){
          cron = "*/10 * * * * *";
        }
        CronTrigger cronTrigger = new CronTrigger(cron);
        Date nextExecutionTime = cronTrigger.nextExecutionTime(triggerContext);
        return nextExecutionTime;
      }
    });
  }


}
