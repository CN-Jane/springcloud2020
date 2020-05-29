package com.jane.springcloud.dao;

import com.jane.springcloud.entites.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@SuppressWarnings({"unused"})
@Repository
@Mapper
public interface PaymentDao {

    /**
     * 保存方法
     * @Author <wangjian>
     * @Description
     * @Date 2020/5/27 0027 14:53
     * @param payment
     * @return
     */
    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);

}
