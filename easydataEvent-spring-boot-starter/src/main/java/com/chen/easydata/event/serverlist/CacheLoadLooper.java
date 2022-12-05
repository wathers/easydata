package com.chen.easydata.event.serverlist;


import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingFactory;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import com.alibaba.nacos.api.naming.pojo.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;

public class CacheLoadLooper implements Callable<Map<String, List<String>>> {

    private Properties properties;

    public CacheLoadLooper(Properties properties) {
        this.properties = properties;
    }

    @Override
    public Map<String, List<String>> call() {
        return getServices();
    }

    public Map<String, List<String>> getServices() {
        Map<String, List<String>> map = new ConcurrentHashMap<>();
        try {
            NamingService naming = NamingFactory.createNamingService(properties);
            ListView<String> servicesOfServer = naming.getServicesOfServer(0, 100);
            servicesOfServer.getData().forEach(servername -> {
                try {
                    List<String> urls = new ArrayList<>();
                    List<Instance> instanceList = naming.getAllInstances(servername);
                    instanceList.forEach(e -> {
                        urls.add("http://"+e.getIp() + ":" + e.getPort() + "/easydata/eventreciver/");
                    });
                    map.put(servername, urls);
                } catch (NacosException e) {
                    e.printStackTrace();
                }
            });
        } catch (NacosException e) {
            e.printStackTrace();
        }
        return map;
    }
}
