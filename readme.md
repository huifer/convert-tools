# 对象转换工具

- 本项目是为了减少在Java项目中搜索对象转换的一个工具包. 

## 功能
- 提供统一的对象转换入口进行转换

## 使用

### SpringBoot
- 在SpringBoot项目中的使用过程如下

1. 编写 convert 相关实现, 继承 `com.github.huifer.convert.think.api.CommonConvert` 接口进行开发


1. 启动类添加注解`@EnableCommonConvert(scanPackages = {"com.github.huifer.comvert.example.convet"})`
    - `scanPackages` 代表了 `CommonConvert` 接口实现的存放位置
    
1. 使用 `com.github.huifer.convert.think.impl.ConvertFacade.convert`方法获取转换结果


完整代码请查看[SpringBootExample](/example/spring-boot-example)



### Java
1. 编写 convert 相关实现, 继承 `com.github.huifer.convert.think.api.CommonConvert` 接口进行开发
1. 在项目中`start`方法或者`main`方法中调用 `CommonConvertRunner.start(new String[] {"com.github.huifer.convert.think"})`
1. 使用 `com.github.huifer.convert.think.impl.ConvertFacade.convert`方法获取转换结果


完整代码请查看[JavaExample](/think/src/test)