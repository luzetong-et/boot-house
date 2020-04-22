package com.etoak.controller;

import com.etoak.bean.House;
import com.etoak.bean.HouseVo;
import com.etoak.bean.Page;
import com.etoak.service.HouseService;
import com.etoak.utils.ValidationUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2020/4/21.
 */
@Controller
@RequestMapping("/house")
@Slf4j
public class HouseController {
    @Autowired
    HouseService houseService;


    @RequestMapping("/toAdd")
    public String toAdd(){
        return "house/add";
    }

    @Value("${upload.dir}")
    public String uploadDirectory;
    @Value("${upload.savePathPrefix}")
    private String savePathPrefix;



    @PostMapping("/add")
    public String add(@RequestParam("file") MultipartFile file,House house,BindingResult bingResult) throws IOException {

        ValidationUtil.validate(house);

        String originalFilename =file.getOriginalFilename();
        //  String suffix = FilenameUtils.getExtension(originalFilename);
        String prefix= UUID.randomUUID().toString().replaceAll("-","");
        String newFilename=prefix+"_"+originalFilename;

        File destFile=new File(this.uploadDirectory,newFilename);
        file.transferTo(destFile);
        // 给House设置访问地址
        house.setPic(this.savePathPrefix + newFilename);
        houseService.addHouse(house);
        return "redirect:/house/toAdd";
    }




    @PostMapping("/add2")
    public String add2(@RequestParam("file") MultipartFile file,House house,BindingResult bingResult) throws IOException {

        List<ObjectError> allError=bingResult.getAllErrors();
        if(CollectionUtils.isNotEmpty(allError)){
            StringBuffer msgBuffer=new StringBuffer();
            for(ObjectError objectError :allError){
                String message=objectError.getDefaultMessage();
                msgBuffer.append(message).append(";");
            }
            throw  new RuntimeException("参数校验失败"+msgBuffer.toString());
        }

        String originalFilename =file.getOriginalFilename();
      //  String suffix = FilenameUtils.getExtension(originalFilename);
        String prefix= UUID.randomUUID().toString().replaceAll("-","");
        String newFilename=prefix+"_"+originalFilename;

        File destFile=new File(this.uploadDirectory,newFilename);
        file.transferTo(destFile);
// 给House设置访问地址
        house.setPic(this.savePathPrefix + newFilename);
        houseService.addHouse(house);
        return "redirect:/house/toAdd";
    }

    @GetMapping(value="/list",produces = "application/json;charset=utf-8")
    @ResponseBody
    public Page<HouseVo> queryList(
            @RequestParam(required = false,defaultValue = "1") int pageNum,
            @RequestParam(required = false,defaultValue = "10") int pageSize,
            HouseVo houseVo
    ){
        log.info("pageNum - {},pageSize - {}, houseVo - {}",pageNum,pageSize,houseVo);
        return houseService.queryList(pageNum,pageSize,houseVo);
    }


}
