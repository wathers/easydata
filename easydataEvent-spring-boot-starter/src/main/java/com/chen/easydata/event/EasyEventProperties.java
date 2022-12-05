package com.chen.easydata.event;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("easydata.event")
public class EasyEventProperties {

    private String testv;

    public String getTestv() {
        return testv;
    }

    public void setTestv(String testv) {
        this.testv = testv;
    }
}
