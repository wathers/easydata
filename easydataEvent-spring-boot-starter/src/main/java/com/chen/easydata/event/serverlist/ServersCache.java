package com.chen.easydata.event.serverlist;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class ServersCache {

    private Map<String, List<String>> map = new ConcurrentHashMap<>();


    public void loadCache(Map<String, List<String>> map){
        this.map = map;
    }

    public List<String> getAllUrls(){
        List<String> resultlist= new ArrayList<>();
        if(map.size()>0){
            for (List<String> value : map.values()) {
                resultlist.addAll(value);
            }
        }
        return resultlist;
    }

    public boolean isEmpty(){
        return this.map.isEmpty();
    }

    public List<String> getUrlByServiceName(String servicename){
        return map.get(servicename);
    }
}
