# Android组件化项目

### 初始化Module

这个项目只是组件化项目的模块部分（简称：插件）

组件化项目分为宿主项目跟插件项目

[宿主部分>>>](https://github.com/Leeii/LComponentProject)


##### 准备工作
1. Android Studio (以下简称AS)
2. JAVA 8
3. git

##### 如何初始化？
1. 将项目克隆到本地，如果已经克隆，忽略
2. 用 AS 打开项目
3. 使用`git checkout -b xxx` xxx代表你要新建的分支名称，如`git checkout -b task` 意思就是切换到task分支，
如果不存在该分支，就新建该分支(当然不止这一种方式可以切换分支)
4. 此时你就在你新建的分支上，如果不确定，可以在AS的终端窗口（terminal）输入`git status` 查看分支名
5. 修改包名将 `com.leeiidesu.module.template` 选中,并且按`shift + F6`(默认快捷键,就是rename) 将template改为你的模块名
6. 修改类名 凡是以 `Template*****.java` 命名的类都需要将 Template 改为你的模块名
7. 在包名上新建`ui`包，用于页面代码
8. 开始你的编码

##### 插件


##### 注意事项
1. 每个分支就是一个模块，除了merge master以外，不要merge其他分支
2.
