package com.chen.dataserver.daotests;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chen.easydata.server.EasyDataServerApplication;
import com.chen.easydata.server.mapper.TaskInfoMapper;
import com.chen.easydata.server.model.pojo.TaskInfo;
import javafx.concurrent.Task;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@SpringBootTest(classes = EasyDataServerApplication.class)
public class TaskInfoTests {

    @Resource
    private TaskInfoMapper taskInfoMapper;

    @Test
    public void testQuery() {
        List<TaskInfo> taskInfos = taskInfoMapper.selectList(null);
        taskInfos.forEach(e->{
            System.out.println(e);
        });
    }

    @Test
    public void testQueryCondition() {
        List<TaskInfo> taskInfos = taskInfoMapper.selectList(new QueryWrapper<TaskInfo>().eq("id",1));
        taskInfos.forEach(e->{
            System.out.println(e);
        });
    }

    @Test
    public void testInsert(){
        TaskInfo taskInfo = new TaskInfo();
        taskInfo.setTaskname("abc");
        taskInfo.setTaskSchedulerExpr("");
        taskInfo.setCreateTime(new Date());
        taskInfo.setCreateUser("a");
        taskInfo.setUpdateTime(new Date());
        taskInfo.setUpdateUser("a");
        taskInfo.setTaskStatus(1);
        taskInfoMapper.insert(taskInfo);
    }
}
