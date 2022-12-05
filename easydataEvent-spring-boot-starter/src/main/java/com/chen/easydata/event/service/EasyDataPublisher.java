package com.chen.easydata.event.service;

import com.alibaba.nacos.api.PropertyKeyConst;
import com.alibaba.nacos.client.naming.NacosNamingService;
import com.chen.easydata.event.bo.EasyDataEvent;
import com.chen.easydata.event.serverlist.CacheLoadLooper;
import com.chen.easydata.event.serverlist.ServersCache;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Properties;

@Component
public class EasyDataPublisher {

    @Autowired
    private Environment environment;

    @Autowired
    private ServersCache serversCache;

    private RestTemplate restTemplate = new RestTemplate();

    /**
     * 发送其实是调用所有url的接口
     *
     * @param event
     */
    public void sendEvent(EasyDataEvent event) {
        getServerList();
        for (String allUrl : serversCache.getAllUrls()) {
            //发送事件的请求给各个服务
            restTemplate.postForEntity(allUrl,event,String.class);
        }
    }

    public void getServerList() {
        if (serversCache.isEmpty()) {
            String nacosUrl = environment.getProperty("spring.cloud.nacos.discovery.server-addr");
            String namespace = environment.getProperty("spring.cloud.nacos.discovery.namespace");
            Properties properties = new Properties();
            properties.put(PropertyKeyConst.NAMESPACE, namespace);
            properties.put(PropertyKeyConst.SERVER_ADDR, nacosUrl);
            serversCache.loadCache(new CacheLoadLooper(properties).getServices());
        }
    }


}
