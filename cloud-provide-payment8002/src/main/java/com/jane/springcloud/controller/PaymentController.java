package com.jane.springcloud.controller;

import com.jane.springcloud.entites.CommonResult;
import com.jane.springcloud.entites.Payment;
import com.jane.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
@SuppressWarnings({"unchecked", "unused"})
public class PaymentController {

    private static final int SUCCESS_BASIC_VALUE = 0;
    private static final Integer SUCCESS_CODE = 200;
    private static final Integer ERROR_CODE = 205;

    @Resource
    private PaymentService paymentService;

    @Value(value = "${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("****插入结果：" + result);
        CommonResult commonResult = new CommonResult();
        if (result > SUCCESS_BASIC_VALUE) {
            commonResult.setCode(SUCCESS_CODE);
            commonResult.setMessage("插入成功, sererPort:" + serverPort);
            commonResult.setData(result);
        } else {
            commonResult.setCode(ERROR_CODE);
            commonResult.setMessage("插入失败");
            commonResult.setData(null);
        }
        return commonResult;
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("查询结果：" + payment);
        CommonResult commonResult = new CommonResult();
        if (null != payment) {
            commonResult.setCode(SUCCESS_CODE);
            commonResult.setMessage("查询成功,serverPort:" + serverPort);
            commonResult.setData(payment);
        } else {
            commonResult.setCode(ERROR_CODE);
            commonResult.setMessage("没有对应记录，查询ID：" + id);
            commonResult.setData(null);
        }
        return commonResult;
    }

}
