package com.priv.service.impl;

import com.priv.service.RewardStrategy;
import com.priv.service.StrategyFactory;

/**
 * 具体工厂创建具体的策略
 *
 * @author Json
 * @date 2021/4/9 16:46
 */
public class FactorRewardStrategyFactory extends StrategyFactory {

    @Override
    public RewardStrategy createStrategy(Class c) {
        RewardStrategy strategy = null;
        try {
            // 票务系统是通过name获取Bean.
            strategy = (RewardStrategy) Class.forName(c.getName()).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return strategy;
    }
}
