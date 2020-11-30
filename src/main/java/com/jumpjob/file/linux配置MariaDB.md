#### 一、下载安装包

 ![img](https://climg.mukewang.com/5dc229fc08228c6f03510135.jpg) 

#### 二、按顺序安装依赖环境包

```bash
yum install rsync nmap lsof perl-DBI nc
rpm -ivh jemalloc-3.6.0-1.el7.x86_64.rpm
rpm -ivh jemalloc-devel-3.6.0-1.el7.x86_64.rpm
```

#### 三、卸载冲突的 MariaDB-libs

1. 先搜索

   ```bash
   rpm -qa | grep mariadb-libs
   ```

2. 后删除

   ```bash
   rpm -ev --nodeps mariadb-libs-5.5.60-1.el7_5.x86_64
   ```

3. 安装 boost-devel 依赖环境

   ```bash
   yum install boost-devel.x86_64
   ```

4. 导入 MariaDB 的 key

   ```bash
   rpm --import http://yum.mariadb.org/RPM-GPG-KEY-MariaDB
   ```

5. 安装 galera 环境

   ```bash
   rpm -ivh galera-4-26.4.2-1.rhel7.el7.centos.x86_64.rpm
   ```

6. 安装 libaio (此步骤在安装 10.4.8 的时候需要)

   ```bash
   wget http://mirror.centos.org/centos/6/os/x86_64/Packages/libaio-0.3.107-10.el6.x86_64.rpm
   rpm -ivh libaio-0.3.107-10.el6.x86_64.rpm
   ```

7. 安装 MariaDB 的四个核心包

   ```bash
   rpm -ivh 
   MariaDB-common-10.4.7-1.el7.centos.x86_64.rpm 
   MariaDB-compat-10.4.7-1.el7.centos.x86_64.rpm 
   MariaDB-client-10.4.7-1.el7.centos.x86_64.rpm 
   MariaDB-server-10.4.7-1.el7.centos.x86_64.rpm
   ```

8. 启动服务

   ```bash
   service mysql start
   ```

9. 进行安全配置

   ```bash
   mysql_secure_installation
   1.输入当前密码，初次安装后是没有密码的，直接回车
   2.询问是否使用`unix_socket`进行身份验证：n
   3.为root设置密码：y
   4.输入root的新密码：root
   5.确认输入root的新密码：root
   6.是否移除匿名用户，这个随意，建议删除：y
   7.拒绝用户远程登录，这个建议开启：n
   8.删除test库，可以保留：n
   9.重新加载权限表：y
   ```

10. 进入控制台

    - 输入密码

      mysql -u root -p

    - 赋予 root 用户远程连接权限

      ```mysql
      grant all privileges on *.* to 'root'@'%' identified by 'root密码';
      flush privileges;
      ```

      