package com.meowu.starter.mybatis.criteria.expression;

import lombok.Setter;

@Setter
public class Selection{

    private String field;
    private String alias;

    public Selection(String field){
        this.field = field;
    }

    public Selection alias(String alias){
        this.alias = alias;
        return this;
    }
}
