package com.priv.demo;

import java.util.concurrent.*;

/**
 * @author Json
 * @date 2021/3/9 21:11
 */
public class ScheduledThreadDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        /*
         * 平时我们在执行一个定时任务时，会采用Time和TimeTask来组合处理；
         * 但是Timer和TimerTask存在一些缺陷：
         * 1:Timer只创建了一个线程 当你的任务执行的时间超过设置的延时时间将会产生一些问题;
         * 2:Timer创建的线程没有处理异常 因此一旦抛出非受检异常 该线程会立即终止;
         */
        ScheduledThreadPoolExecutor executorService
                = new ScheduledThreadPoolExecutor(10, new ThreadPoolExecutor.CallerRunsPolicy());

        executeScheduleWithFixedDelay(executorService);

        //executeScheduleAtFixedRate(executorService);
        //
        //executeSchedule(executorService);
    }

    /**
     * 间隔1秒执行一次
     */
    private static void executeScheduleWithFixedDelay(ScheduledExecutorService executorService) throws InterruptedException, ExecutionException {

        ScheduledFuture<?> result = executorService.scheduleWithFixedDelay(
                () -> {
                    System.out.println("scheduleWithFixedDelay-" + System.currentTimeMillis());
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }, 1000, 1000, TimeUnit.MILLISECONDS
        );
        result.get();
    }

    /**
     * 线程在第3秒开始执行
     */
    private static void executeScheduleAtFixedRate(ScheduledExecutorService executorService) throws InterruptedException, ExecutionException {

        ScheduledFuture<?> result = executorService.scheduleAtFixedRate(
                () -> {
                    System.out.println("scheduleAtFixedRate-" + System.currentTimeMillis());
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }, 1000, 3000, TimeUnit.MILLISECONDS
        );
        result.get();
    }

    /**
     * 线程延迟3秒执行,仅执行一次
     */
    private static void executeSchedule(ScheduledExecutorService executorService) throws InterruptedException, ExecutionException {

        ScheduledFuture<?> result = executorService.schedule(
                () -> {
                    System.out.println("schedule-" + System.currentTimeMillis());
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }, 3000, TimeUnit.MILLISECONDS
        );
        result.get();
    }
}
