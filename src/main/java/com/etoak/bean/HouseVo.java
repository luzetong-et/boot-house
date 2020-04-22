package com.etoak.bean;

import lombok.Data;
import sun.security.krb5.internal.HostAddress;

/**
 * Created by Administrator on 2020/4/22.
 */
@Data
public class HouseVo extends House {
   private String rentModeName;
   private String houseTypeName;
   private String orientationName;
}
