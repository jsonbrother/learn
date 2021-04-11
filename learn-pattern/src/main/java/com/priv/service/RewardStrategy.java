package com.priv.service;

/**
 * 抽象策略
 *
 * @author Json
 * @date 2021/4/9 16:44
 */
public abstract class RewardStrategy {

    /**
     * 计算报酬
     * @param userId 用户id
     * @return 报酬
     */
    public abstract int reward(String userId);

    /**
     * 更新用户信息以及结算
     */
    public void insertRewardAndSettlement(String userId, int reward) {
        System.out.println("更新用户信息以及结算");
    };
}
