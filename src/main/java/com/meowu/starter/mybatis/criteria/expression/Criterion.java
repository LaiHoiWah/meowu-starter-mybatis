package com.meowu.starter.mybatis.criteria.expression;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Criterion{

    private String field;
    private String operator;
    private Object value;
    private String criterionType;
    private String valueType;

    public Criterion(){

    }
}
