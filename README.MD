springmvc使用，包含spring上下文和springmvc上下文获取
父容器spring中的bean(对象)对controller（子容器springmvc）是可见的，但是父容器加载的属性变量只是对父容器spring本身中的对象可见；
所以controller使用 @Value注解无法在子容器springMVC中获得对应的属性值，只能取得容器赋予的默认值。

解决方法：

1、再次加载

  在springMVC中再次扫描属性文件，加载到springMVC这一子容器中。
  
  //加载配置文件
  
  <context:property-placeholder location="classpath:resource/*.properties"/>
  
2、bean传值

  在service类中使用 @Value注解，加载spring的属性。因为service类对于子容器可见，调用service获取value，可以传值。