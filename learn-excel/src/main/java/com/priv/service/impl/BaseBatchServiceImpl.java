package com.priv.service.impl;

import com.priv.service.IBaseBatchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Json
 * @date 2021/2/24 22:57
 */
@Service
public class BaseBatchServiceImpl implements IBaseBatchService {

    private final static Logger logger = LoggerFactory.getLogger(BaseBatchServiceImpl.class);

    @Override
    public void batchSaveData(List<?> list) {

        list.forEach(e -> System.out.println(e.toString()));

        logger.info("批处理保存数据完成");
    }
}
