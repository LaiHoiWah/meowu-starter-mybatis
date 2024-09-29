package com.meowu.starter.mybatis.utils;

import com.meowu.starter.commons.utils.AssertionUtils;
import com.meowu.starter.commons.utils.ReflectionUtils;
import com.meowu.starter.commons.utils.StringUtils;
import com.meowu.starter.mybatis.security.stereotype.ColumnName;
import com.meowu.starter.mybatis.security.stereotype.TableName;

import java.lang.reflect.Field;
import java.util.function.Function;

public class FieldUtils{

    public static String getTableName(Class<?> classOf){
        AssertionUtils.notNull(classOf, "Entity class must not be null");

        TableName annotation = classOf.getAnnotation(TableName.class);

        if(annotation == null || StringUtils.isBlank(annotation.value())){
            return StringUtils.lowerCase(classOf.getName());
        }else{
            return annotation.value();
        }
    }

    public static <T, R> String getColumnName(Function<T, R> getter){
        AssertionUtils.notNull(getter, "Getter function must not be null");

        Field field = ReflectionUtils.getField(getter);
        ColumnName annotation = field.getAnnotation(ColumnName.class);

        if(annotation == null || StringUtils.isBlank(annotation.value())){
            return StringUtils.camelToUnderscoreCase(field.getName());
        }else{
            return annotation.value();
        }
    }
}
