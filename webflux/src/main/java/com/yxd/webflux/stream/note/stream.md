## Stream流编程 - 创建
类型 | 相关方法
--- | ---
集合 | Collection.stream/parallelStream
数组 | Arrays.stream
数字Stream | IntStream/LongStream.range/rangeClosed/
数字Stream | Random.ints/longs/doubles
自己创建 | Stream.generate/iterator 
  
  
## Stream流编程 - 中间操作
类型 | 相关方法
--- | ---
无状态操作 | map/mapToXxx
无状态操作 | flatMap/flatMapToXxx
无状态操作 | filter
无状态操作 | peek
无状态操作 | unordered
有状态操作 | distinct
有状态操作 | sorted
有状态操作 | limit/skip

## Stream流编程 - 终止操作
类型 | 相关方法
--- | ---
非短路操作 | forEach/forEachOrdered
非短路操作 | collect/toArray
非短路操作 | reduce
非短路操作 | min/max/count
短路操作 | findFirst/findAny
短路操作 | allMatch/anyMath/noneMatch

## 小记
当使用 `parallel()`并行流时，默认使用的线程池：`ForkJoinPool.commonPool`；

默认的线程个数为当前机器的逻辑处理器个数；使用下面的代码可以修改默认的线程数
```
System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "20");
```

使用自己创建的线程池
```
// 使用自己的线程池，不使用默认的线程池，防止任务被阻塞
ForkJoinPool pool = new ForkJoinPool(20);
pool.submit(()->IntStream.range(1, 100).parallel().peek(StreamDemo5::debug).count());
pool.shutdown();

// 当使用自己的线程池的时候，主线程并不参与，因此可能会导致当主线程退出时，线程池也没有执行任务，因此这里做自旋
while(!pool.isShutdown()){
}
```
## stream 运行机制
1. 所有操作是链式调用，一个元素只迭代一次
2. 每一个中间操作返回一个新的流。流里面有一个属性 `sourceStage` 指向同一个地方：`Head`
3. Head->nextStage->...->null 
4. 有状态操作会把无状态操作单独处理
5. 并行条件下，有状态的中间操作（例如排序），不一定能够并行操作
6. parallel/sequential 这两个操作也是中间操作（也是返回stream），但他们不创建流，他们只修改Head的并行标准 
