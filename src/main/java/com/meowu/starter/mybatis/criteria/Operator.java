package com.meowu.starter.mybatis.criteria;

public interface Operator{

    String EQUAL       = "=";
    String NOT_EQUAL   = "<>";
    String LIKE        = "LIKE";
    String NOT_LIKE    = "NOT LIKE";
    String BETWEEN     = "BETWEEN";
    String NOT_BETWEEN = "NOT BETWEEN";
    String IN          = "IN";
    String NOT_IN      = "NOT IN";
    String IS_NULL     = "IS NULL";
    String NOT_NULL    = "IS NOT NULL";

    String AND = "AND";
    String OR  = "OR";

    String ASC  = "ASC";
    String DESC = "DESC";

    String LIMIT    = "LIMIT";
    String ORDER_BY = "ORDER BY";
    String GROUP_BY = "GROUP BY";

    // function
    String COUNT = "COUNT";
}
