





Future 接口可以为主线程开一个分支任务，专门为主线程处理耗时和费力的复杂任务。

● 优点：Future+线程池异步多线程任务配合，能显著提高程序的运行效率。
● 缺点：
    ○ get()阻塞---一旦调用get()方法求结果，一旦调用不见不散，非要等到结果才会离开，不管你是否计算完成，如果没有计算完成容易程序堵塞。
    ○ isDone()轮询---轮询的方式会耗费无谓的cpu资源，而且也不见得能及时得到计算结果，如果想要异步获取结果，
                    通常会以轮询的方式去获取结果，尽量不要阻塞。
● 结论：Future对于结果的获取不是很友好，只能通过阻塞或轮询的方式得到任务的结果。


Future 完成一些复杂的任务 java 5
● 对于简单的业务场景使用Future完全ok
● 回调通知：
    ○ 应对Future的完成时间，完成了可以告诉我，也就是我们的回调通知
    ○ 通过轮询的方式去判断任务是否完成这样非常占cpu并且代码也不优雅
● 创建异步任务：Future+线程池组合
● 多个任务前后依赖可以组合处理（水煮鱼--->买鱼--->调料--->下锅）： 有异步顺序
    ○ 想将多个异步任务的结果组合起来，后一个异步任务的计算结果需要钱一个异步任务的值
    ○ 想将两个或多个异步计算合并成为一个异步计算，这几个异步计算互相独立，同时后面这个又依赖前一个处理的结果
● 对计算速度选最快的：
    ○ 当Future集合中某个任务最快结束时，返回结果，返回第一名处理结果
● 结论：
    ○ 使用Future之前提供的那点API就囊中羞涩，处理起来不够优雅，这时候还是让CompletableFuture以声明式的方式优雅的处理这些需求。
    ○ 从i到i++
    ○ Future能干的，CompletableFuture都能干

于是产生更强大的CompletableFuture



可完成
CompletableFuture对Future的改进  java 8

CompletionStage 任务的步骤，一步步    实现异步任务编排                  
根据CompletableFuture依赖数量 零依赖、单依赖、双重依赖和多重依赖

不用new 而是用静态的方法, runAsync（无返回值）  supplyAsync（有返回值）
4个静态方法：对应的 noreturn (demo1 demo2)   has return(demo3 demo4) 


注意：
使用的默认的ForkJoinPool.commonPool-worker-9 类似于守护线程，当main函数结束时，CompletableFutur中的ForkJoinPool也会关闭 导致异步任务未完成
在实际的工作中 要写自己自定义的线程池


都能从 CompletableFuture 中获取结果
但是 join 和 get 的区别 编译的时候是否报出检查机制 

CompletableFuture优点：
● 异步任务结束时，会自动回调某个对象的方法
● 主线程设置好回调后，不用关心异步任务的执行，异步任务之间可以顺序执行
● 异步任务出错时，会自动回调某个对象的方法



