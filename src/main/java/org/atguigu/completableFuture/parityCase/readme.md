


切记：功能--->性能（完成--->完美） 开发的过程   先追求功能，再追求性能


电商网站比价需求分析：
1. 需求说明：
   a. 同一款产品，同时搜索出同款产品在各大电商平台的售价
   b. 同一款产品，同时搜索出本产品在同一个电商平台下，各个入驻卖家售价是多少
2. 输出返回：
   a. 出来结果希望是同款产品的在不同地方的价格清单列表，返回一个List<String>
   例如：
   《Mysql》 in jd price is 88.05  
   《Mysql》 in taobao price is 90.43

3. 解决方案，对比同一个产品在各个平台上的价格，要求获得一个清单列表
   a. step by step，按部就班，查完淘宝   查京东，查完京东  查天猫....
   b. all in，万箭齐发，一口气多线程异步任务同时查询



![img.png](img.png)


异常
![img_1.png](img_1.png)