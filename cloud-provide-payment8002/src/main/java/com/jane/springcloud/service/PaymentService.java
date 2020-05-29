package com.jane.springcloud.service;

import com.jane.springcloud.entites.Payment;
import org.apache.ibatis.annotations.Param;

@SuppressWarnings({"unused"})
public interface PaymentService {

    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);

}
