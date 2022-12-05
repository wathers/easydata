package com.chen.easydata.server.events;

import com.chen.easydata.event.bo.EasyDataEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class TestApplicationListener implements ApplicationListener<EasyDataEvent> {

    @Override
    public void onApplicationEvent(EasyDataEvent event) {
        System.out.println("收到消息,"+event.getSource());
    }
}
