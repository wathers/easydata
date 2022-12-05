package com.chen.easydata.event.bo;

import org.springframework.context.ApplicationEvent;

public class EasyDataEvent extends ApplicationEvent {
    public EasyDataEvent(Object source) {
        super(source);
    }
}
