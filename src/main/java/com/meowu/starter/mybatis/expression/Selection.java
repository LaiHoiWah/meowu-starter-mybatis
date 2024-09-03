package com.meowu.starter.mybatis.expression;

import lombok.Getter;

@Getter
public class Selection{

    private String field;
    private String alias;

    public Selection(){

    }

    public Selection(String field){
        this.field = field;
    }

    public Selection alias(String alias){
        this.alias = alias;
        return this;
    }
}
