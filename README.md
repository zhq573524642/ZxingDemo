# ZxingDemo

## 谷歌Zxing的使用Demo

功能：1.可以生成二维码   2.可以扫描二维码（并且可以调起相册的二维码进行扫描，打开闪光灯）

效果图：

## 生成二维码

![image text](https://github.com/zhq573524642/ZxingDemo/blob/master/image/%E7%94%9F%E6%88%90%E4%BA%8C%E7%BB%B4%E7%A0%81.gif)

## 扫描二维码

## 注：效果图扫描的是一张有二维码的截图，可以扫描任何二维码，会调起浏览器加载

![image text](https://github.com/zhq573524642/ZxingDemo/blob/master/image/%E4%BA%8C%E7%BB%B4%E7%A0%81%E6%89%AB%E6%8F%8F.gif)

## 调起手机相册

![image text](https://github.com/zhq573524642/ZxingDemo/blob/master/image/%E8%B0%83%E8%B5%B7%E7%9B%B8%E5%86%8C.gif)

# 集成步骤：

## 1.在项目的build.gradle添加下面代码

     allprojects {
       repositories {
          maven { url "https://jitpack.io" }
       }
    }

## 2.在Module的build.gradle添加依赖

     compile 'com.github.open-android:Zxing:v1.0.3'
   
## 3. 添加一些必要的权限

    <uses-permission android:name="android.permission.CAMERA" />
    <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
    <uses-feature android:name="android.hardware.camera" />
    <uses-feature android:name="android.hardware.camera.autofocus" />
    <uses-permission android:name="android.permission.VIBRATE" />
    <uses-permission android:name="android.permission.FLASHLIGHT" />
    
## 4.详细生成二维码、扫描二维码等逻辑请查看Demo，很简单的，可以的话给个star，嘻嘻~~~~~

