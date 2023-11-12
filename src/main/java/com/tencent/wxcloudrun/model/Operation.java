package com.tencent.wxcloudrun.model;



import java.io.Serializable;
import java.time.LocalDateTime;

public class Operation implements Serializable{
    private int OID;

    private int GID;

    private int UserID;

    private int Otype;

    private LocalDateTime Otime;
}
