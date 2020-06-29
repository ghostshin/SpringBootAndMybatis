package com.example.demo.config;

import java.util.Date;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import com.example.demo.mapper.TimerMapper;

//接口方式实现定时任务

@Configuration // 1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling // 2.开启定时任务
public class DynamicScheduleTask implements SchedulingConfigurer {

	@Autowired // 注入mapper
	@SuppressWarnings("all")
	TimerMapper timerMapper;

	/**
	 * 执行定时任务.
	 */
	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {

		taskRegistrar.addTriggerTask(
				// 1.添加任务内容(Runnable)
				new Runnable() {
					public void run() {
						System.out.println("定时任务");
					}
				}, new Trigger() {

					@Override
					public Date nextExecutionTime(TriggerContext triggerContext) {
						// TODO Auto-generated method stub
						String cron = timerMapper.getCronByid(1);

						return new CronTrigger(cron).nextExecutionTime(triggerContext);
					}
				}

		// // 2.设置执行周期(Trigger)
		// triggerContext -> {
		// // 2.1 从数据库获取执行周期
		// String cron = timerMapper.getCronByid(1);
		// // 2.2 合法性校验.
		// // if (StringUtils.isEmpty(cron)) {
		// // // Omitted Code ..
		// // }
		// // 2.3 返回执行周期(Date)
		//
		//
		// Date a = new CronTrigger(cron).nextExecutionTime(triggerContext);
		// return a;
		// }
		//

		);
	}

}
