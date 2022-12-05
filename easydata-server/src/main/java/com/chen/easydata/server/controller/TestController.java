package com.chen.easydata.server.controller;

import com.chen.easydata.event.bo.EasyDataEvent;
import com.chen.easydata.event.service.EasyDataPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private EasyDataPublisher publisher;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public void test() {
        publisher.sendEvent(new EasyDataEvent("ssssss"));
    }
}
