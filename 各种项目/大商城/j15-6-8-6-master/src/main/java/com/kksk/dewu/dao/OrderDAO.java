package com.kksk.dewu.dao;

import com.kksk.dewu.dataobject.OrderDO;
import com.kksk.dewu.param.QueryOrderParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderDAO {
    int insert(OrderDO order);

    int selectCounts(QueryOrderParam param);

    List<OrderDO> pageQuery(QueryOrderParam param);

    OrderDO selectByOrderNumber(String orderNumber);

    int update(OrderDO orderDO);
}
