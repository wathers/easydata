package com.chen.easydata.server.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@MapperScan("com.chen.easydata.server.mapper")
@Configuration
public class MybatisConfig {

}
