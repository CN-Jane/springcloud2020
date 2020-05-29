package com.jane.springcloud.entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description 支付实体类
 * @Author <wangjian>
 * @Date 2020/5/27 0027 14:44
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuppressWarnings({"unused"})
public class Payment implements Serializable {

    private Long id;
    private String serial;

}
