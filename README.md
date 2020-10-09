以前只会使用jpa，突然换成mybatis，不太熟悉，下文主要是说如何spingboot中使用mybatis

### 1 创建一个有mybatis的依赖
![2020-10-09 21-04-38 的屏幕截图.png](https://upload-images.jianshu.io/upload_images/16893788-f9eef115414247f8.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

### 在pom.xml文件中可以看到
```
        <dependency>
            <groupId>org.mybatis.spring.boot</groupId>
            <artifactId>mybatis-spring-boot-starter</artifactId>
            <version>2.1.3</version>
        </dependency>
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <scope>runtime</scope>
        </dependency>
```
### 数据库链接
```
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=${JDBC_URL}
spring.datasource.password=${JDBC_PASSWORD}
```

### 基础配置搞定，开始撸代码
创建一个Dto
```
@Data
public class User implements Serializable {
    private Long id;
    private String username;
    private String password;
}
```
创建一个对应Mapper
```
import com.example.demoforuniapp.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User findByUsername(String username);
}
```
创建一个service
```
@Service
@Slf4j
public class UserService {

    @Autowired
    UserMapper userMapper;

    public User findOne(String username){
        log.info(username);
        return userMapper.findByUsername(username);
    }
}
```
### 在resources文件夹下创建一个mappers文件夹，并创建一个UserMapper.xml文件
![2020-10-09 21-15-08 的屏幕截图.png](https://upload-images.jianshu.io/upload_images/16893788-2da35421968c8181.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

UserMapper.xml内容
```
<?xml version="1.0" encoding="utf-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
<mapper namespace="com.example.demoforuniapp.mapper.UserMapper">
    <select id="findByUsername" resultType="com.example.demoforuniapp.entity.User">
        SELECT * FROM user_entity where username=#{username}
    </select>
</mapper>
```

这里要强调一点，mapper的xml存放在resources文件夹下，在springboot进行打包时，并不会加载，这里我们需要在pom.xml指定加载
```
<build>
        <resources>
            <resource>
                <directory>src/main/resources</directory>
            </resource>
            <resource>
                <directory>src/main/resources</directory>
                <includes>
                    <include>mappers/*.xml</include>
                </includes>
            </resource>
        </resources>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>
```
同时确认一下properties文件中mybatis的配置是否一致
