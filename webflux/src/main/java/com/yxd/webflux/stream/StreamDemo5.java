package com.yxd.webflux.stream;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @author yuxudong
 * @date 2019/11/10 21:32
 */
public class StreamDemo5 {
    public static void main(String[] args) {
        // parallel 产生并行流

        // 现在要实现这样一个效果： 先并行，再串行
        // 结论：多次调用 parallel/sequential，以最后一次为准
        IntStream.range(1, 100)
                // 调用 parallel 产生并行流
                .parallel().peek(StreamDemo5::debug)
                // 调用 sequential 产生串行流
                //.sequential().peek(StreamDemo5::debug)
                .count();

        // 并行流使用的线程池：ForkJoinPool.commonPool
        // 默认的线程个数为当前机器的 逻辑处理器个数
        // 修改默认线程数
        //System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "20");

        // 使用自己的线程池，不使用默认的线程池，防止任务被阻塞
        ForkJoinPool pool = new ForkJoinPool(20);
        pool.submit(()->IntStream.range(1, 100).parallel().peek(StreamDemo5::debug).count());
        pool.shutdown();

        // 当使用自己的线程池的时候，主线程并不参与，因此可能会导致当主线程退出时，线程池也没有执行任务，因此这里做自旋
        while(!pool.isShutdown()){
        }


    }
    public static void debug(int i){
        System.out.println(Thread.currentThread().getName() + ": debug " + i);
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
