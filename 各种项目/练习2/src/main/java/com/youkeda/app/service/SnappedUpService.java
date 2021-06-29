package com.youkeda.app.service;

import com.youkeda.app.model.Result;

/**
 * @Author jiaoheng
 * @DATE 2020-06-10
 */
public interface SnappedUpService {
    /**
     * 抢购
     */
    Result<Boolean> snappedUp(Long id);
}
