#### 一、nginx安装

1. ##### 安装 gcc 环境

   yum install gcc-c++

2. ##### 安装 PCRE 库，用于解析正则表达式

   yum install -y pcre pcre-devel

3. ##### zlib 压缩和解压缩依赖

   yum install -y zlib zlib-devel

4. ##### SSL 安全的加密的套接字协议层，用于 HTTP 安全传输，也就是 https

   yum install -y openssl openssl-devel

5. ##### 解压，先创建 nginx 临时目录，如果不创建，启动报错

   tar -zxvf nginx-1.18.1.tar.gz

6. ##### 创建临时目录

   mkdir /var/temp/nginx -p

7. ##### 在 nginx 目录，进行如下配置，创建 makefile 文件

   ```bash
   ./configure \
   --prefix=/usr/local/nginx \
   --pid-path=/var/run/nginx/nginx.pid \
   --lock-path=/var/lock/nginx.lock \
   --error-log-path=/var/log/nginx/error.log \
   --http-log-path=/var/log/nginx/access.log \
   --with-http_gzip_static_module \
   --http-client-body-temp-path=/var/temp/nginx/client \
   --http-proxy-temp-path=/var/temp/nginx/proxy \
   --http-fastcgi-temp-path=/var/temp/nginx/fastcgi \
   --http-uwsgi-temp-path=/var/temp/nginx/uwsgi \
   --http-scgi-temp-path=/var/temp/nginx/scgi
   ```

   

8. ##### make 编译

   make

9. ##### 安装

   make install

10. ##### 进入 sbin 目录启动 nginx

    - ./nginx
    - ./nginx -s stop
    - ./nginx -s quit
    - ./nginx -s reload
    - ./nginx -t

11. ##### 注意事项

    - 防火墙
    - 端口号

####  二、nginx 配置跨域

```bash
#允许跨域请求的域，*代表所有
add_header 'Access-Control-Allow-Origin' *;
#允许带上cookie请求
add_header 'Access-Control-Allow-Credentials' 'true';
#允许请求的方法，比如 GET/POST/PUT/DELETE
add_header 'Access-Control-Allow-Methods' *;
#允许请求的header
add_header 'Access-Control-Allow-Headers' *;
```

#### 三、nginx 日志切割

1. ##### 创建一个 shell 可执行文件：cut_my_log.sh 内容为：

   ```bash
   #!/bin/bash
   LOG_PATH="/var/log/nginx/"
   RECORD_TIME=$(date -d "yesterday" +%Y-%m-%d+%H:%M)
   PID=/var/run/nginx/nginx.pid
   mv ${LOG_PATH}/access.log ${LOG_PATH}/access.${RECORD_TIME}.log
   mv ${LOG_PATH}/error.log ${LOG_PATH}/error.${RECORD_TIME}.log
   
   #向Nginx主进程发送信号，用于重新打开日志文件
   kill -USR1 `cat $PID`
   ```

2. ##### 为 cut_my_log.sh 添加可执行权限

   ```bash
   chmod +x cut_my_log.sh
   ```

3. ##### 测试日志切割后的结果

   ```bash
   ./cut_my_log.sh
   ```

#### 四、nginx 日志切割-定时

1. ##### 安装定时任务

   yum install crontabs

2. ##### crontab -e 编辑并且添加一行新的任务

   ```bash
   */1 * * * * /usr/local/nginx/sbin/cut_my_log.sh
   ```

3. ##### 启动定时任务

4. ##### 常用命令

   ```
   service crond start         //启动服务
   service crond stop          //关闭服务
   service crond restart       //重启服务
   service crond reload        //重新载入配置
   crontab -e                  // 编辑任务
   crontab -l                  // 查看任务列表
   ```

5. ##### 常用表达式

   - 每分钟执行

     ```
     */1 * * * *
     ```

   - 每日凌晨执行

     ```
     59 23 * * *
     ```

   - 每日凌晨一点执行

     ```
     0 1 * * *
     ```


#### 五、nginx 配置静态资源防盗链

```bash
#对源站点验证
valid_referers *.imooc.com; 
#非法引入会进入下方判断
if ($invalid_referer) {
    return 404;
} 
```

