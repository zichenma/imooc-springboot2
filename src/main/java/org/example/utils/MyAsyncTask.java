package org.example.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

// !!!只能在单体项目中使用，微服和分布式并不适用
@Component
@EnableAsync
@Slf4j
public class MyAsyncTask {
    @Async
    public void publishMsg() {
        try {
            Thread.sleep(5000);
            log.warn("Async task finished");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
