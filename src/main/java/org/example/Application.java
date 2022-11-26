package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan; // 一定要是 tk.mybatis

/**
 * 1. 表明当前项目为 SpringBoot 工程，这是一个启动类，也是应用程序的入口类
 * 2. 启动类需要放在根包路径之下 (org.example), 因为他会默认扫描 controller 和 service 以及 mapper 等一些相关的组件
 * 扫描完了之后，会放到 spring/springboot 的容器中
 */
@SpringBootApplication
@MapperScan(basePackages = "org.example.mapper") // 扫描所有 mapper 放入到容器里面去
public class Application {
    public static  void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}