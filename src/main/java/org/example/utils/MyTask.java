package org.example.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;

// !!!只能在单体项目中使用，微服和分布式并不适用
//@Configuration // 1. 标记配置类，使得 springboot 容器可以扫描到
//@EnableScheduling // 2. 开始定时任务
@Slf4j
public class MyTask {
    // 3. 添加一个任务，并且注明任务的运行表达式
    /**
     * For example, "0 * * * * MON-FRI" means once per minute on weekdays (at the top of the minute - the 0th second).
     * The fields read from left to right are interpreted as follows.
     * second
     * minute
     * hour
     * day of month
     * month
     * day of week
     */
    @Scheduled(cron = "*/5 * * * * ?")
    public void publishMsg() {
        log.warn("Start execute task " + LocalDateTime.now());
    }
}
