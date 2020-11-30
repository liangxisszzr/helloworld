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

#### 六、UpStream 指令参数

1. ##### max_conns

   ```nginx
   # worker进程设置1个，便于测试观察成功的连接数
   worker_processes  1;
   
   upstream tomcats {
           server 192.168.1.173:8080 max_conns=2;
           server 192.168.1.174:8080 max_conns=2;
           server 192.168.1.175:8080 max_conns=2;
   }
   ```

2. ##### slow_start

   ```nginx
   upstream tomcats {
           server 192.168.1.173:8080 weight=6 slow_start=60s;
   #       server 192.168.1.190:8080;
           server 192.168.1.174:8080 weight=2;
           server 192.168.1.175:8080 weight=2;
   }
   ```

   注意：

   - 该参数不能使用在 `hash` 和 `random load balancing` 中
   - 如果在 `upstream` 中只有一台 `server`，则该参数失效

3. ##### down、backup

   `down` 用于标记服务节点不可用：

   ```nginx
   upstream tomcats {
           server 192.168.1.173:8080 down;
   #       server 192.168.1.190:8080;
           server 192.168.1.174:8080 weight=1;
           server 192.168.1.175:8080 weight=1;
   }
   ```

   `backup`表示当前服务器节点是备用机，只有在其他的服务器都宕机以后，自己才会加入到集群中，被用户访问到：

   ```nginx
   upstream tomcats {
           server 192.168.1.173:8080 backup;
   #       server 192.168.1.190:8080;
           server 192.168.1.174:8080 weight=1;
           server 192.168.1.175:8080 weight=1;
   }
   ```

   ##### 注意

   - `backup`参数不能使用在`hash`和`random load balancing`中。

4. ##### max_fails、fail_timeout

   `max_fails`：表示失败几次，则标记server已宕机，剔出上游服务。
   `fail_timeout`：表示失败的重试时间。
   假设目前设置如下：

   ```nginx
   max_fails=2 fail_timeout=15s 
   ```

   则代表在15秒内请求某一server失败达到2次后，则认为该server已经挂了或者宕机了，随后再过15秒，这15秒内不会有新的请求到达刚刚挂掉的节点上，而是会请求到正常运作的server，15秒后会再有新请求尝试连接挂掉的server，如果还是失败，重复上一过程，直到恢复

5. ##### keepalive

   `keepalive`： 设置长连接处理的数量
   `proxy_http_version`：设置长连接http版本为1.1
   `proxy_set_header`：清除connection header 信息

   ```nginx
   upstream tomcats {
   #       server 192.168.1.173:8080 max_fails=2 fail_timeout=1s;
           server 192.168.1.190:8080;
   #       server 192.168.1.174:8080 weight=1;
   #       server 192.168.1.175:8080 weight=1;
           keepalive 32;
   }
   
   server {
           listen       80;
           server_name  www.tomcats.com;
   
           location / {
               proxy_pass  http://tomcats;
               proxy_http_version 1.1;
               proxy_set_header Connection "";
           }
       }
   ```

6. ##### ip_hash

   `ip_hash` 可以保证用户访问可以请求到上游服务中的固定的服务器，前提是用户ip没有发生更改。
   使用ip_hash的注意点：
   不能把后台服务器直接移除，只能标记`down`.

   > If one of the servers needs to be temporarily removed, it should be marked with the down parameter in order to preserve the current hashing of client IP addresses.

   ```nginx
   upstream tomcats {
           ip_hash;
   
           server 192.168.1.173:8080;
           server 192.168.1.174:8080 down;
           server 192.168.1.175:8080;
   }
   ```

   参考：
   http://nginx.org/en/docs/http/ngx_http_upstream_module.html#ip_hash

7. ##### 负载均衡 url_hash 与 least_conn

   ```nginx
   upstream tomcats {
       # url hash
       hash $request_uri;
       # 最少连接数
       # least_conn
   
       server 192.168.1.173:8080;
       server 192.168.1.174:8080;
       server 192.168.1.175:8080;
   }
   
   
   server {
       listen 80;
       server_name www.tomcats.com;
   
       location / {
           proxy_pass  http://tomcats;
       }
   }
   ```

#### 七、nginx 的缓存

1. ##### 浏览器缓存

   加速用户访问，提升单个用户体验，缓存在本地

2. ##### nginx 缓存

   - 缓存在 nginx 端，提升所有访问到 nginx 这一端的用户
   - 提升访问上游服务器（upstream）的速度
   - 用户访问仍然会产生请求流量

3. ##### 控制浏览器缓存

   ```nginx
   #expires 命令控制一下浏览器的缓存,主要是针对一些静态资源
   location / {
   expires 10s; # 允许浏览器缓存该资源10s
   expires @22h30m; # @指定时间点 后过期
   expires -1h; # 比当前时间提前一小时过期
   expires epoch; # 不使用缓存了
   expires off; # 默认关闭
   expires max; # 最大时间,永不过期
   }  
   ```

   

4. ##### nginx 的反向代理缓存

   ```nginx
   # proxy_cache_path 设置缓存目录
   #       keys_zone 设置共享内存以及占用空间大小
   #       max_size 设置缓存大小
   #       inactive 超过此时间则被清理
   #       use_temp_path 临时目录，使用后会影响nginx性能
   proxy_cache_path /usr/local/nginx/upstream_cache keys_zone=mycache:5m max_size=1g inactive=1m use_temp_path=off;
   location / {
       proxy_pass  http://tomcats;
   
       # 启用缓存，和keys_zone一致
       proxy_cache mycache;
       # 针对200和304状态码缓存时间为8小时
       proxy_cache_valid   200 304 8h;
   }
   ```

#### 八、使用 nginx 配置 https 域名证书

1. ##### 安装 SSL 模块

   - 进入到nginx的解压目录： /home/software/nginx-1.16.1

   - 新增ssl模块(原来的那些模块需要保留)

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
     --http-scgi-temp-path=/var/temp/nginx/scgi  \
     --with-http_ssl_module
     ```

   - 编译和安装

     ```bash
     make
     make install
     ```

2. ##### 配置 HTTPS

   - 把ssl证书 `*.crt` 和 私钥 `*.key` 拷贝到`/usr/local/nginx/conf`目录中。

   - 新增 server 监听 443 端口：

     ```nginx
     server {
         listen       443;
         server_name  www.imoocdsp.com;
     
         # 开启ssl
         ssl     on;
         # 配置ssl证书
         ssl_certificate      1_www.imoocdsp.com_bundle.crt;
         # 配置证书秘钥
         ssl_certificate_key  2_www.imoocdsp.com.key;
     
         # ssl会话cache
         ssl_session_cache    shared:SSL:1m;
         # ssl会话超时时间
         ssl_session_timeout  5m;
     
         # 配置加密套件，写法遵循 openssl 标准
         ssl_protocols TLSv1 TLSv1.1 TLSv1.2;
         ssl_ciphers ECDHE-RSA-AES128-GCM-SHA256:HIGH:!aNULL:!MD5:!RC4:!DHE;
         ssl_prefer_server_ciphers on;
         
         location / {
             proxy_pass http://tomcats/;
             index  index.html index.htm;
         }
      }
     ```

3. ##### reload nginx

   ```nginx
   ./nginx -s reload
   ```

   腾讯云Nginx配置https文档地址：https://cloud.tencent.com/document/product/400/35244

