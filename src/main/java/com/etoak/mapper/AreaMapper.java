package com.etoak.mapper;

import com.etoak.bean.Area;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2020/4/20.
 */
public interface AreaMapper {
   List<Area> queryByPid(@Param("pid") int pid);
   Area queryById(@Param("id") int id);
}
