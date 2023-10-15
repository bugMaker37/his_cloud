#!/bin/sh

# 复制项目的文件到对应docker路径，便于一键生成镜像。
usage() {
	echo "Usage: sh copy.sh"
	exit 1
}


# copy sql
echo "begin copy sql "
cp ../sql/ry_20230706.sql ./mysql/db
cp ../sql/ry_config_20220929.sql ./mysql/db

# copy html
echo "begin copy html "
cp -r ../his-ui/dist/** ./nginx/html/dist


# copy jar
echo "begin copy his-gateway "
cp ../his-gateway/target/his-gateway.jar ./ruoyi/gateway/jar

echo "begin copy his-auth "
cp ../his-auth/target/his-auth.jar ./ruoyi/auth/jar

echo "begin copy his-visual "
cp ../his-visual/his-monitor/target/his-visual-monitor.jar  ./ruoyi/visual/monitor/jar

echo "begin copy his-modules-system "
cp ../his-modules/his-system/target/his-modules-system.jar ./ruoyi/modules/system/jar

echo "begin copy his-modules-file "
cp ../his-modules/his-file/target/his-modules-file.jar ./ruoyi/modules/file/jar

echo "begin copy his-modules-job "
cp ../his-modules/his-job/target/his-modules-job.jar ./ruoyi/modules/job/jar

echo "begin copy his-modules-gen "
cp ../his-modules/his-gen/target/his-modules-gen.jar ./ruoyi/modules/gen/jar

