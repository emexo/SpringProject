package com.bugtacking.asyncconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

@Configuration
@EnableAsync
public class AsyncConfig {

    @Bean("asyncBean")
    public Executor asyncConfig(){
        ThreadPoolTaskExecutor threadPoolExecutor = new ThreadPoolTaskExecutor();
        threadPoolExecutor.setCorePoolSize(5);
        threadPoolExecutor.setMaxPoolSize(50);
        threadPoolExecutor.setQueueCapacity(100);
        threadPoolExecutor.setThreadNamePrefix("bugtrackingasync-");
        threadPoolExecutor.initialize();
        return threadPoolExecutor;
    }
}
