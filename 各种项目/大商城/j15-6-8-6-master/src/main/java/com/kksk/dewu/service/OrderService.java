package com.kksk.dewu.service;

import com.kksk.dewu.model.Order;
import com.kksk.dewu.model.OrderStatus;
import com.kksk.dewu.param.QueryOrderParam;
import com.kksk.dewu.model.Paging;

public interface OrderService {
    /**
     * 下单
     *
     * @param order 接收的Order模型
     * @return
     */
    public Order add(Order order);

    /**
     * 查询订单
     *
     * @param queryOrderParam 查询参数
     * @return
     */
    Paging<Order> queryRecentPaySuccess(QueryOrderParam queryOrderParam);

    /**
     * 根据订单号查询
     *
     * @return
     */
    Order getByOrderNumber(String orderNumber);

    /**
     * 更新订单状态
     *
     * @param orderNumber 订单号
     * @param orderStatus 订单状态
     * @return Order
     */
    Order updateOrderStatus(String orderNumber, OrderStatus orderStatus);

    /**
     * 更新
     * @param orderNumber
     * @return
     */
    Order updateProductPersonNumber(String orderNumber);
}
