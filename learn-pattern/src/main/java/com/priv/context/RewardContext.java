package com.priv.context;

import com.priv.service.RewardStrategy;

/**
 * @author Json
 * @date 2021/4/9 16:52
 */
public class RewardContext {

    private RewardStrategy strategy;

    public RewardContext(RewardStrategy strategy) {
        this.strategy = strategy;
    }

    public void doStrategy(String userId) {
        int reward = strategy.reward(userId);
        strategy.insertRewardAndSettlement(userId, reward);
    }
}
