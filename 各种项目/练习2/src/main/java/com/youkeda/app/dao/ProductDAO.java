package com.youkeda.app.dao;

import com.youkeda.app.dataobject.ProductDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductDAO {
    int insert(ProductDO productDO);

    ProductDO selectById(long id);
    
    int updateStock(ProductDO productDO);
}
