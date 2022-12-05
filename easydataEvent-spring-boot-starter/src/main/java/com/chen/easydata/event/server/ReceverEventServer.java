package com.chen.easydata.event.server;


import com.chen.easydata.event.bo.EasyDataEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReceverEventServer {

    @Autowired
    private ApplicationEventPublisher publisher;

    @RequestMapping(value = "/easydata/eventreciver/", method = RequestMethod.POST)
    public void eventreciver(@RequestBody EasyDataEvent event) {
        System.out.println("ReceverEventServer has connectioned");
        publisher.publishEvent(event);
    }
}
