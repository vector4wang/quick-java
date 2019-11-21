# OCJP 笔记

### 接口

- 接口可以重新声明default方法，也可以使其抽象

- 静态方法永远不能被抽象，不管是在接口中还是在类中
- 接口可以有静态方法，但是需要有主体
- default方法必须要有主体
- 接口方法不能同时静态和默认



### 包装类型

- 使用`equal`时，第一部是比较类型是否相等
- 



### 多态

- 调用哪个实例方法取决于实际对象的类，而访问哪个字段（和静态方法）则取决于变量的类



### Switch

- Switch中作为一个代码块，可以声明变量并到处使用



### String

- 请记住，包装器类（java.lang.Boolean，java.lang.Integer，java.lang.Long，java.lang.Short等）也是最终的，因此无法扩展
- java.lang.Number不是最终的。整数，长整数，双精度等扩展数字
- java.lang.System is final as well.



### 重写

- 父类中是object返回类型，子类随便返回