package com.meowu.starter.mybatis.utils;

import com.meowu.starter.commons.utils.ReflectionUtils;
import com.meowu.starter.commons.utils.StringUtils;
import com.meowu.starter.mybatis.security.stereotype.FieldName;

import java.lang.reflect.Field;
import java.util.function.Function;

public class FieldUtils{

    public static <T, R> String getFieldName(Function<T, R> getter){
        Field field = ReflectionUtils.getField(getter);
        FieldName annotation = field.getAnnotation(FieldName.class);

        if(annotation == null){
            return StringUtils.camelToUnderscoreCase(field.getName());
        }else{
            String fieldName = annotation.value();
            return StringUtils.isBlank(fieldName) ? StringUtils.camelToUnderscoreCase(field.getName()) : fieldName;
        }
    }
}
