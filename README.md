# WeDPR-Lab-Java-SDK

## 如何体验WeDPR-Lab-Java-SDK

WeDPR-Lab-Java-SDK是WeDPR-Lab的Java客户端。

### 快速体验

请在WeDPR-Lab-Java-SDK项目目录下执行。

```bash
# 下载仓库
git clone -b develop https://github.com/WeBankBlockchain/WeDPR-Lab-Java-SDK.git && cd ./WeDPR-Lab-Java-SDK
# 获取动态库
curl -LO https://github.com/WeBankBlockchain/WeDPR-Lab-Java-SDK/releases/download/v0.0.1/lab-core-dynamic-libs.tar.gz
# 解压
tar zxvf lab-core-dynamic-libs.tar.gz
# 拷贝动态库至加载路径
cp ./lab-core-dynamic-libs/* ./solution/vcl/src/main/resources/WeDPR_dynamic_lib
# 编译项目
bash ./gradlew clean build
# 进入项目目录
cd demo/dist/
# 运行demo
java -cp "apps/*:conf/:libs/*" com.webank.wedpr.demo.DemoMain
```
