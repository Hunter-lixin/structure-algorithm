# Spring Boot配置文件放在jar外部
Spring Boot程序默认从`application.properties`或者`application.yml`读取配置，如何将配置信息外置，方便配置呢？

查询官网，可以得到下面的几种方案:

#### 通过命令行指定
`SpringApplication`会默认将命令行选项参数转换为配置信息

例如，启动时命令参数指定：
```
java -jar myproject.jar --server.port = 9000
```
从命令行指定配置项的优先级最高，不过你可以通过`setAddCommandLineProperties`来禁用
```
SpringApplication.setAddCommandLineProperties(false).
```
#### 外置配置文件
Spring程序会按优先级从下面这些路径来加载`application.properties`配置文件
```
当前目录下的/config目录
当前目录
classpath里的/config目录
classpath 跟目录
```
因此，要外置配置文件就很简单了，在jar所在目录新建config文件夹，然后放入配置文件，或者直接放在配置文件在jar目录

#### 自定义配置文件
如果你不想使用`application.properties`作为配置文件，怎么办？完全没问题
```
java -jar myproject.jar --spring.config.location=classpath:/default.properties,classpath:/override.properties
```
或者
```
java -jar -Dspring.config.location=D:\config\config.properties springbootrestdemo-0.0.1-SNAPSHOT.jar 
```
当然，还能在代码里指定
```java
@SpringBootApplication
@PropertySource(value={"file:config.properties"})
public class SpringbootrestdemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootrestdemoApplication.class, args);
    }
}
```
#### 按Profile不同环境读取不同配置
不同环境的配置设置一个配置文件，例如：
- dev环境下的配置配置在application-dev.properties中；
- prod环境下的配置配置在application-prod.properties中。
  在`application.properties`中指定使用哪一个文件
```
spring.profiles.active = dev
```
当然，你也可以在运行的时候手动指定：
```
java -jar myproject.jar --spring.profiles.active = prod
```
