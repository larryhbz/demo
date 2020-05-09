package com.example.demo.config;
import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LoggerOperation {
    String value();//所调用接口的名称
    String type();//所调用接口的类型
}
