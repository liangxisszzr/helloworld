#### 一、检查默认安装

java -version

#### 二、检查系统安装的 OpenJDK

rpm -qa | grep openjdk -i

#### 三、删除 openjdk 的安装包并且检查后显示删除完毕

rpm -e --nodeps 需要删除的软件

四、安装 jdk

1. ##### 新建 jdk 安装目录

   mkdir /usr/java

2. ##### 使用 ftp 工具上传 jdk 到某目录，如下：

   /home/software

3. ##### 解压 jdk 压缩包

   tar -zxvf jdk-**.tar.gz

4. ##### 把解压后的 jdk 放到 /usr/java 下，这个目录专门用于存放 jdk

   mv jdk-**/ /usr/java/

5. ##### 配置环境变量

   修改 profile 文件

   ```bash
   vim /etc/profile
   ```

   配置 jdk 环境变量

   ```bash
   export JAVA_HOME=/usr/java/jdk1.8.0_191
   export CLASSPATH=.:%JAVA_HOME%/lib/dt.jar:%JAVA_HOME%/lib/tools.jar  
   export PATH=$PATH:$JAVA_HOME/bin
   ```

   注：环境变量配置在 profile 文件最末尾即可

6. ##### 刷新 profile，使其生效

   source /etc/profile

   再次检查 jdk