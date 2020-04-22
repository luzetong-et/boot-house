package com.etoak.service;

import com.etoak.bean.House;
import com.etoak.bean.HouseVo;
import com.etoak.bean.Page;

/**
 * Created by Administrator on 2020/4/22.
 */
public interface HouseService {
    int addHouse(House house);

    Page<HouseVo> queryList(int pageNum,int pageSize,HouseVo houseVo);
}
