# WeDPR-Lab-Java-SDK

Label: Develop

## 如何体验WeDPR-Lab-Java-SDK

WeDPR-Lab-Java-SDK通过JNI调用rust产生动态库实现的相应密码组件

### 快速体验

请在WeDPR-Lab-Java-SDK项目目录下执行
```bash
# 获取动态库
curl -Lo https://github.com/WeBankBlockchain/WeDPR-Lab-Java-SDK/releases/download/v0.0.1/lab-core-dynamic-libs.tar.gz
# 解压
tar zxvf lab-core-dynamic-libs
# 拷贝动态库至加载路径
cp ./lab-core-dynamic-libs/* ./solution/vcl/src/main/resources/WeDPR_dynamic_lib/
# 编译项目
bash ./gradlew clean build
# 进入项目目录
cd solution/vcl/dist/
# 运行demo
java -cp "apps/*:conf/:libs/*" com.webank.wedpr.vcl.DemoMain
```

### 源码体验

#### 下载动态库

通过访问`https://github.com/WeBankBlockchain/WeDPR-Lab-Java-SDK/releases/tag/v0.0.1`，下载`lab-core-dynamic-libs.tar.gz
`，解压后根据自己所处操作系统将动态库放置于solution/vcl/src/main/resources/WeDPR_dynamic_lib下

*.dll -> windows

*.dylib -> macOs

*.so -> linux 需要为centos7.2或ubuntu16.04以上版本

#### 编译动态库

访问https://github.com/WeBankBlockchain/WeDPR-Lab-Core，编译develop分支，生成动态库

#### 调用demo

执行`com.webank.wedpr.vcl.DemoMain`查看调用示例，或使用gradle构建项目后在solution/vcl/dist下执行

```bash
java -cp "apps/*:conf/:libs/*" com.webank.wedpr.vcl.DemoMain
```

#### 查看JNI

相应调用代码可以查看solution/vcl
