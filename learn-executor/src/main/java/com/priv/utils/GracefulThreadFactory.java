package com.priv.utils;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 线程工厂
 * 它设置线程名称 有利于我们定位问题
 *
 * @author Json
 * @date 2021/3/15 9:46
 */
public class GracefulThreadFactory implements ThreadFactory {

    private final AtomicInteger threadNum = new AtomicInteger();
    private final ThreadFactory delegate;
    private final String name;

    /**
     * 创建一个带名字的线程池生产工厂
     */
    public GracefulThreadFactory(ThreadFactory delegate, String name) {
        this.delegate = delegate;
        // TODO consider unedifying this
        this.name = name;
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = delegate.newThread(r);
        t.setName(name + " [#" + threadNum.incrementAndGet() + "]");
        return t;
    }
}
