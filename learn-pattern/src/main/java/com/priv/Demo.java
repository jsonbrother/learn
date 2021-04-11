package com.priv;

import com.priv.context.RewardContext;
import com.priv.service.RewardStrategy;
import com.priv.service.impl.FactorRewardStrategyFactory;
import com.priv.service.impl.NewUserBasicReward;
import com.priv.service.impl.OldUserBasicReward;

/**
 * @author Json
 * @date 2021/4/9 16:55
 */
public class Demo {

    public static void main(String[] args) {
        // 创建策略工厂
        FactorRewardStrategyFactory strategyFactory = new FactorRewardStrategyFactory();

        // 根据用户id查询用户信息
        String userId = "210117DYZD6FKTHH";

        // 新用户返奖策略
        RewardStrategy rewardStrategy = strategyFactory.createStrategy(NewUserBasicReward.class);
        RewardContext rewardContext = new RewardContext(rewardStrategy);

        RewardStrategy rewardStrategy2 = strategyFactory.createStrategy(OldUserBasicReward.class);

        // 执行返奖策略
        rewardContext.doStrategy(userId);

    }
}
