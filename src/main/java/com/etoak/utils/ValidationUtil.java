package com.etoak.utils;



import com.etoak.exception.ParamException;
import org.apache.commons.collections4.CollectionUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import javax.validation.Validator;
import java.lang.reflect.Parameter;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Administrator on 2020/4/22.
 */
public class ValidationUtil {
   private static Validator validator;

   static{
       ValidatorFactory factory= Validation.buildDefaultValidatorFactory();
       validator=factory.getValidator();
   }
   public static void validate (Object object){
       Set<ConstraintViolation<Object>> violations=validator.validate(object);
       if(CollectionUtils.isNotEmpty(violations)){
           Iterator<ConstraintViolation<Object>> iterator=violations.iterator();
           StringBuffer mess=new StringBuffer();
           while(iterator.hasNext()){
               ConstraintViolation<Object> violation=iterator.next();
               String message=violation.getMessage();
               mess.append(message).append(";");
           }
           throw  new ParamException("参数错误:"+mess.toString());
       }

   }
}
