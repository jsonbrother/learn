package com.priv.service.impl;

import com.priv.service.RewardStrategy;

/**
 * 老用户返奖具体策略
 *
 * @author Json
 * @date 2021/4/9 16:49
 */
public class OldUserBasicReward extends RewardStrategy {

    @Override
    public int reward(String userId) {
        System.out.println("老用户返奖具体策略");
        return 0;
    }
}
