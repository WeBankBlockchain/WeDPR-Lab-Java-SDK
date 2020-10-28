# WeDPR-Lab-Java-SDK

## 如何体验WeDPR-Lab-Java-SDK

WeDPR-Lab-Java-SDK是WeDPR-Lab的Java客户端。

## 环境依赖

WeDPR Lab Java SDK 依赖如下：

| 依赖软件 | 支持版本 |
| :-: | :-: |
| JAVA | JDK1.8+ |

## 快速体验

```bash
# 下载仓库
git clone https://github.com/WeBankBlockchain/WeDPR-Lab-Java-SDK.git && cd ./WeDPR-Lab-Java-SDK
# 根据操作系统访问release页面获取对应动态库，以mac为例，支持mac、linux和windows版本
curl -LO https://github.com/WeBankBlockchain/WeDPR-Lab-Core/releases/download/v1.1.0/java_sdk_dynamic_lib_mac.tar.gz
# 解压
tar zxvf java_sdk_dynamic_lib_mac.tar.gz
# 拷贝动态库至加载路径
cp ./java_sdk_dynamic_lib_mac/* ./demo/src/main/resources/WeDPR_dynamic_lib
# 编译项目
bash ./gradlew clean build
# 进入项目目录
cd demo/dist
# 运行demo
java -cp "apps/*:conf/:libs/*" com.webank.wedpr.demo.DemoMain
```
