#!/bin/sh
# 这个应用的名称
APP_NAME=blog-server
# 应用端口,在代码中定义过的就不用再次定义
SERVER_PORT=8095
#jar包的存放路径,定义成自己存放jar包的地方
JAR_PATH='/usr/blog-server'
#jar包名字,定义成自己jar包的名字
JAR_NAME=ideas+1.0-SNAPSHOT.jar
#PID代表pid文件
JAR_PID=$JAR_NAME\.pid
#启动时候的日志输出
RUN_LOG=log

#启动参数，需要的时候用，不需要的时候不要用
JAVA_OPTS="-Xms512m -Xmx512m -XX:MetaspaceSize=512m -XX:MaxMetaspaceSize=1024m -XX:ParallelGCThreads=4 -XX:+PrintGCDateStamps -XX:+PrintGCDetails -XX:+HeapDumpOnOutOfMemoryError -Dfile.encoding=utf-8"

is_exist() {
    # 查询出应用服务的进程id，grep -v 是反向查询的意思，查找除了grep操作的run.jar的进程之外的所有进程
    # shellcheck disable=SC2006
    # shellcheck disable=SC2009
    pid=`ps -ef|grep $JAR_NAME|grep -v grep|awk '{print $2}' `
# [ ]表示条件测试。注意这里的空格很重要。要注意在'['后面和']'前面都必须要有空格
  # [ -z STRING ] 如果STRING的长度为零则返回为真，即空是真
  # 如果不存在返回0，存在返回1
    if [ -z "${pid}" ]; then
      return 0
    else
      return 1
    fi
}

# ######### Shell脚本中$0、$?、$!、$$、$*、$#、$@等的说明 #########
# 通用的启动应用的脚本
# $$ Shell本身的PID（ProcessID，即脚本运行的当前 进程ID号）
# $! Shell最后运行的后台Process的PID(后台运行的最后一个进程的 进程ID号)
# $? 最后运行的命令的结束代码（返回值）即执行上一个指令的返回值 (显示最后命令的退出状态。0表示没有错误，其他任何值表明有错误)
# $- 显示shell使用的当前选项，与set命令功能相同
# $* 所有参数列表。如"$*"用「"」括起来的情况、以"$1 $2 … $n"的形式输出所有参数，此选项参数可超过9个。
# $@ 所有参数列表。如"$@"用「"」括起来的情况、以"$1" "$2" … "$n" 的形式输出所有参数。
# $# 添加到Shell的参数个数
# $0 Shell本身的文件名
# $1～$n 添加到Shell的各参数值。$1是第1参数、$2是第2参数…。
start() {
  is_exist
  if [ $? -eq "1" ]; then
    echo "$APP_NAME is already running pid is ${pid}"
  else
    nohup java -jar $JAR_PATH/$JAR_NAME >./$RUN_LOG/run.log 2>&1 &
    echo $! >$JAR_PID
    echo "start $APP_NAME successed pid is $!"
    tail -500f $RUN_LOG/run.log
  fi
}

##应用停止
stop() {
  pidf=$(cat $JAR_PID)
  echo "pid = $pidf begin kill $pidf"
  kill -9 $pidf
  rm -rf $JAR_PID
  sleep 2
  is_exist
  if [ $? -eq "1" ]; then
    echo "pid = $pid begin kill -9 $pid"
    kill -9  $pid
    sleep 2
    echo "$APP_NAME process stopped！"
  else
    echo "$APP_NAME is not running！"
  fi
}

##应用状态检查
status() {
  is_exist
  if [ $? -eq "1" ]; then
    echo "$APP_NAME is running, pid is $pid"
  else
    echo "$APP_NAME is not running"
  fi
}
##应用重启
restart() {
  stop
  start
}

##脚本帮助提示语
usage() {
    echo "Usage: sh run-service.sh [ start | stop | restart | status ]"
    exit 1
}

###################################
# 读取脚本的第一个参数($1)，进行判断
# 参数取值范围：{ start | stop | restart | status }
# 如参数不在指定范围之内，则打印帮助信息
###################################
#根据输入参数，选择执行对应方法，不输入则执行使用说明
case "$1" in
  'start')
    start
    ;;
  'stop')
    stop
    ;;
  'restart')
    restart
    ;;
  'status')
    status
    ;;
  *)
    usage
    ;;
esac
exit 0
