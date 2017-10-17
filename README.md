# ButtonNoXml
### 使用selector和shape标签来定制Button的不足
1. 在Android开发中经常使用到button控件，我们通常通过xml定义selector和shape标签来定制button，这样做代码量虽然不是很大，但是需要定义多个xml文件才能完成一个按钮，需要耗费一些时间，并且使得项目xml文件过多且可读性差。
2. 使用selector和shape标签来定制button，必须在编译前就需要写死xml代码，无法运行中动态修改button样式，所以xml无法满足这种需求。

### 改用Java代码定义Button
ButtonNoXml不是一个自定义View，只是使用了Android提供的类去替代xml定义button。使用ButtonNoXml我们可以告别xml按钮了，Java代码使得代码简洁易读，进一步减小项目文件数量，同时如果你需要在运行时改变button的属性，那估计就必须要用java代码来做了。

### 使用
``` xml
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```
``` xml
dependencies {
    compile 'com.github.vibexie:ButtonNoXml:v1.0.0'
}
```
``` java
Drawable drawable = new ButtonNoXml.Builder(this)
                .unpressedColor("#445da4")//正常背景色
                .pressedColor("#888888")//按下背景色
                .radius(10)//圆角
                .selectable(false)//是否可select
                .semicircle(false)//是否是两边半圆
                .strokeWidth(2)//描边宽度
                .strokeColor("#ff0000")//描边颜色
                .build();
button.setBackgroundDrawable(drawable);
```
![img](http://qiniu.vibexie.com/blog/button_no_xml.png?imageView2/2/h/500)

### 说明
ButtonNoXml只是本人根据自己有限的经验想出的一种替代selector和shape标签的方案，如果你有更好的方案，我们可以互相探讨。