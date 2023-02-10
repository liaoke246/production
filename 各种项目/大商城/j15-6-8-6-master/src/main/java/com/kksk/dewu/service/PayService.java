package com.kksk.dewu.service;

import com.kksk.dewu.model.Result;
import com.kksk.dewu.param.PaymentParam;

import java.util.Map;

public interface PayService {
    /**
     * 支付订单
     *
     * @param paymentParam 支付所需参数
     * @return Result
     */
    Result payOrder(PaymentParam paymentParam);

    /**
     * 支付宝回调接口
     *
     * @param mapParam 支付宝参数
     * @return Result
     */
    Result alipayCallBack(Map<String, String> mapParam);
}
