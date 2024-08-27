package com.meowu.starter.mybatis.criteria;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Criterion{

    private String field;
    private String operator;
    private Object value;
    private ValueType valueType;
}
