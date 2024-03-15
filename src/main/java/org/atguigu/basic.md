



java util concurrent    juc  concurrent(同时发生的)

parallel
concurrent

process
thread
monitor 锁对象 就是管程


程序(运行后)->进程->线程
线程的状态`

run
start
runnable
wait
time_wait


start->start0 ->native(操作系统留出的接口，用户态->内核态 中断trap指令)
调用底层操作系统，调用第三方语言
java=(c++) =>  (c++) -- 封装比较难得部分
java的java openjdk ,下载源码hotSport  是jvm 配好操作系统 然后调用操作系统原生的线程方法
