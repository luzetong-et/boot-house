package com.etoak.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by Administrator on 2020/4/22.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Page<T> {
    private int pageNum;
    private int pageSize;
    private List<T> rows;
    private long total;
    private int pageCount;
}
