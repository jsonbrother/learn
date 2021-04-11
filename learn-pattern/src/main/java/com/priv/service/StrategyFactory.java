package com.priv.service;

/**
 * 抽象工厂
 *
 * @author Json
 * @date 2021/4/9 16:43
 */
public abstract class StrategyFactory<T> {

    /**
     * 创建策略
     */
    public abstract RewardStrategy createStrategy(Class<T> c);
}
