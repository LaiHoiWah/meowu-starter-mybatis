package com.meowu.starter.mybatis.criteria;

public interface Operator{

    String EQUAL                 = "=";
    String NOT_EQUAL             = "<>";
    String LESS_THAN             = "<";
    String LESS_THAN_OR_EQUAL    = "<=";
    String GREATER_THAN          = ">";
    String GREATER_THAN_OR_EQUAL = ">=";
    String LIKE                  = "LIKE";
    String NOT_LIKE              = "NOT LIKE";
    String BETWEEN               = "BETWEEN";
    String NOT_BETWEEN           = "NOT BETWEEN";
    String IN                    = "IN";
    String NOT_IN                = "NOT IN";
}
