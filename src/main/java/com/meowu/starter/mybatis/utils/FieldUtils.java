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

        if(annotation == null){
            return StringUtils.lowerCase(classOf.getName());
        }else{
            String tableName = annotation.value();
            return StringUtils.isBlank(tableName) ? StringUtils.lowerCase(classOf.getName()) : tableName;
        }
    }

    public static <T, R> String getColumnName(Function<T, R> getter){
        AssertionUtils.notNull(getter, "Getter function must not be null");

        Field field = ReflectionUtils.getField(getter);
        ColumnName annotation = field.getAnnotation(ColumnName.class);

        if(annotation == null){
            return StringUtils.camelToUnderscoreCase(field.getName());
        }else{
            String columnName = annotation.value();
            return StringUtils.isBlank(columnName) ? StringUtils.camelToUnderscoreCase(field.getName()) : columnName;
        }
    }
}
