# mapstruct 增强

1. 寻找带有 `org.mapstruct.Mapper` 注解的类
2. 在寻找到的类中寻找方法上带有 `Mappings` 或者 `Mapping` 获取 参数类型和返回值类型
3. 