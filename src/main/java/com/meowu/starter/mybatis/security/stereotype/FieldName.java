package com.meowu.starter.mybatis.security.stereotype;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FieldName{

    String value() default "";
}
