package com.etoak.bean;

import lombok.Data;

import javax.validation.constraints.*;

/**
 * Created by Administrator on 2020/4/22.
 */
@Data
public class House {
    private Integer id;
    @NotNull(message = "省份必填")
    private Integer province;
    @NotNull(message = "市必填")
    private Integer city;
    @NotNull(message = "区必填")
    private Integer area;
    private String areaName;

    @NotNull(message = "租赁方式必填")
    @NotBlank(message = "租赁方式不能为空")
    private String rentMode;
    private String orientation;
    private String houseType;
    @NotNull(message = "租金必填")
    @NotNull(message = "租金必填")
    @Max(value = 100000,message = "租金不能超过十万")
    @Min(value = 100,message = "租金不能小于一百")
    private Integer rental;
    @Size(max=10,min=1,message = "最大10最小1")
    @NotNull(message = "地址必填")
    private String address;
    private String pic;
    private String publishTime;
}
