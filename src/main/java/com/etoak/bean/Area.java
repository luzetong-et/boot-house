package com.etoak.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by Administrator on 2020/4/20.
 */
@Data
public class Area implements Serializable {
    private Integer id;
    private Integer pid;
    private Integer sort;
    private String name;
}
