package com.etoak.controller;

import com.etoak.bean.Dict;
import com.etoak.service.DictService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Administrator on 2020/4/21.
 */
@RestController
@RequestMapping("/dict")
@Slf4j
@Api(tags="字典查询服务")
public class DictController {
   @Autowired
    DictService dictService;
   @ApiOperation(value="根据groupId查询字典列表",notes="查询字典列表")
   @ApiImplicitParam(value="字典组id",name="groupId",
   required = true,paramType = "path")

   @GetMapping("/{groupId}")
    public List<Dict> queryList(@PathVariable("groupId") String groupId){
       log.info("gropupId - {}",groupId);
       return dictService.queryList(groupId);
    }
}
