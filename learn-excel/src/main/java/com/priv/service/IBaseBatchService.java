package com.priv.service;

import java.util.List;

/**
 * @author Json
 * @date 2021/2/24 22:56
 */
public interface IBaseBatchService {

    /**
     * 批量新增数据
     *
     * @param list 数据集合
     */
    void batchSaveData(List<?> list);
}
