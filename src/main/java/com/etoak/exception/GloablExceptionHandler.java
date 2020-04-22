package com.etoak.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Administrator on 2020/4/22.
 */
@ControllerAdvice
@Slf4j
public class GloablExceptionHandler {
    @ExceptionHandler(ParamException.class)
    public ModelAndView handleParamException(ParamException e){
        log.error(e.getMessage(),e);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("error",e.getMessage());
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
