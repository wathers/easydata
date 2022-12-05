package com.chen.easydata.event;

import com.chen.easydata.event.serverlist.ServersCache;
import com.chen.easydata.event.service.EasyDataPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(EasyEventProperties.class)
public class EasyEventConfig {
    @Autowired
    private EasyEventProperties easyEventProperties;

    @Bean
    public EasyDataPublisher easyDataPublisher(){
        return new EasyDataPublisher();
    }

    @Bean
    public ServersCache serversCache(){
        return new ServersCache();
    }
}
