package com.youkeda.app.service;

import com.youkeda.app.model.Result;

/**
 * @Author jiaoheng
 * @DATE 2020-06-10
 */
public interface TicketPurchaseService {
    /**
     * 抢购
     */
    public Result<Boolean> ticketPurchase(long id);
}
