# 对象转换

- 在使用 mapstruct 的过程中经常会有N多个类需要去记忆或者去查询到具体的转换方法在那个类然后在使用下面这样的代码来进行转换调用


```java
UserEntity userEntity = new UserEntity();

userEntity.setName("a");

UserTarget userTarget = UserConvert.INSTANCE.toTarget(userEntity);
```

- 本项目是希望可以通过一个统一的方法然后来得到转换结果. 代码如下

```java
    UserTarget convert = MapstructFacade.convert(userEntity, UserTarget.class);
```