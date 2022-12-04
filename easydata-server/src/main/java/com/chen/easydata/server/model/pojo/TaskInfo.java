package com.chen.easydata.server.model.pojo;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class TaskInfo {

    private long id;

    private String taskname;

    private String taskSchedulerExpr;

    private int taskStatus;

    private long inputid;

    private long targetCollectionId;

    private Date createTime;

    private String createUser;

    private Date updateTime;

    private String updateUser;
}
