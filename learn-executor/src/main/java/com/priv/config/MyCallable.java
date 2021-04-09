package com.priv.config;

import java.util.concurrent.Callable;

/**
 * @author Json
 * @date 2021/3/4 21:19
 */
public class MyCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        // 返回执行当前Callable的线程名称
        return Thread.currentThread().getName();
    }

}
