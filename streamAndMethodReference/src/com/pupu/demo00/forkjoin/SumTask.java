package com.pupu.demo00.forkjoin;

import java.util.concurrent.RecursiveTask;

/**Sum task class
 * ForkJoinTask代表一个可以并行、合并的任务,它是一个抽象类，它有两个抽象子类：RecursiveAction和RecursiveTask。
 *       RecursiveTask代表有返回值的任务
 *       RecursiveAction代表没有返回值的任务
 * @author lp
 * @since 2020-12-14 14:59:55
 */
public class SumTask extends RecursiveTask<Long> {
    static final int THRESHOLD = 500;//阈值,一次计算的数值个数
    long[] array;
    int start;
    int end;

    /**
     * 对给定的数组进行求和初始化
     * @param array 源数组
     * @param start 开始索引
     * @param end 结束索引
     */
    public SumTask(long[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    /**
     * 计算
     * @return 计算结果
     */
    @Override
    protected Long compute() {
        if (end - start <= THRESHOLD) {
            // 如果任务量足够小,直接计算:
            long sum = 0;
            for (int i = start; i < end; i++) {
                sum += this.array[i];
                // 故意放慢计算速度:
//                try {
//                    Thread.sleep(1);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
            return sum;
        }
        // 任务太大,一分为二:
        int middle = (end + start) / 2;
        System.out.println(String.format("split %d~%d ==> %d~%d, %d~%d", start, end, start, middle, middle, end));
        SumTask subtask1 = new SumTask(this.array, start, middle);
        SumTask subtask2 = new SumTask(this.array, middle, end);
        invokeAll(subtask1, subtask2);

        Long subresult1 = subtask1.join();
        Long subresult2 = subtask2.join();

        Long result = subresult1 + subresult2;

        System.out.println("result = " + subresult1 + " + " + subresult2 + " ==> " + result);
        return result;
    }
}
