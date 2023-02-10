package com.kksk.dewu.dao;

import com.kksk.dewu.dataobject.PaymentRecordDO;
import com.kksk.dewu.param.PaymentRecordQueryParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PaymentRecordDAO {

    int insert(PaymentRecordDO record);

    List<PaymentRecordDO> select(PaymentRecordQueryParam paymentRecordQueryParam);

    int update(PaymentRecordDO record);
}