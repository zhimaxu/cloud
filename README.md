## 平台简介
框架搭建学习若依,但去除了一些用不到的内容【不排除以后学习还会加上】
* 采用前后端分离模式,微服务版本
* 后端采用Spring Boot、Spring Cloud & Alibaba
  * 注册中心Nacos
  * 流量控制Sentinel
  * 分布式事务Seata
  * 持久性框架MyBatis-Plus【若依使用的MyBatis】
* 前段采用Vue3、Vite

## 准备工作

| 软件       | 管理    | 通信    | 备注                      |
|----------|-------|-------|-------------------------|
| redis    |       | 32954 |                         |
| mysql    |       | 32957 | 与mssql二选一【__后期考虑多源兼容__】 |
| mssql    |       | 32951 | 与mssql二选一【__后期考虑多源兼容__】 |
| nacos    | 32955 | 32956 |                         |
| rabbitmq | 32953 | 32952 |                         |
 

## 系统模块
整体模块布局参考若依
* 权限范围与若依略有区别 __部分工作经验对于数据权限范围与若依的权限范围有一定出入所以对其进行了改造__
~~~
com.zhimaxu
├── zhimaxu-common                      //通用模块
│       └── zhimaxu-common-core         //核心模块
│       └── zhimaxu-common-datascope    //权限范围
│       └── zhimaxu-common-datasource   //多源数据库
│       └── zhimaxu-common-redis        //缓存服务
│       └── zhimaxu-common-log          //日志记录
│       └── zhimaxu-common-seata        //分布式事务
│       └── zhimaxu-common-security     //安全模块
│       └── zhimaxu-common-swagger      //系统接口
├── zhimaxu-web                         //前端[9000]
├── zhimaxu-gateway                     //网关[9001]
├── zhimaxu-auth                        //认证中心[9002]
├── zhimaxu-modules                     //业务模块
│       └── zhimaxu-system              //系统模块[9100]
│       └── zhimaxu-job                 //系统模块[9200]
│       └── zhimaxu-file                //系统模块[9300]
├── pom.xml                             //公共依赖
~~~

## 其他注释
前端模块使用的是git子仓库,所以拉取后不要忘记同步更新
~~~ 
在Git中添加子模块（submodule）可以通过以下步骤实现：
打开终端（Terminal）或命令提示符（Command Prompt）。
使用cd命令导航到父仓库的目录下。
执行git submodule add <子仓库的URL>来添加子模块。
例如，如果你想添加一个名为"child_repo"的子模块，其URL为https://github.com/username/child_repo.git，你可以按照以下步骤操作：
cd  /path/to/parent_repo  # 切换到父仓库目录
git submodule add https://github.com/username/child_repo.git path/to/child_repo  # 添加子模块
git commit -m "Add submodule"  # 提交更改
git push  # 推送到远程仓库
这样就会在父仓库中添加一个子模块，并在指定的path/to/child_repo路径下保存子模块的内容。
注意：在克隆包含子模块的仓库时，需要使用--recurse-submodules参数来初始化子模块：
git clone --recurse-submodules https://github.com/username/parent_repo.git
如果已经克隆了父仓库而忘记了--recurse-submodules，可以用以下命令更新子模块：
git submodule update --init --recursive
~~~

## 学习路线
1. 准备空模块
2. 逐步引入模块[①](#Q1)
3. 模块填充顺序[②](#Q2)
   1. 拟定的顺序core->redis->datasource->security

## 所有经历的问题
1. 包版本始终无法找到最新的<span id="Q1"></span>
2. 模块引入顺序互相牵制<span id="Q2"></span>
   1. 先准备核心模块 __core__
   2. 准备 __redis__ 模块时
      1. 无法自动装配。找不到 'RedisConnectionFactory' 类型的 Bean。
      2. 自版本 6.0 起已弃用 org.springframework.cache.annotation.CachingConfigurerSupport