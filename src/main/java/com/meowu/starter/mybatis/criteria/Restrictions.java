package com.meowu.starter.mybatis.criteria;

import com.meowu.starter.commons.utils.AssertionUtils;

public class Restrictions{

    public static Criterion equal(String field, Object comparison){
        AssertionUtils.notBlank(field, "Field name must not be null");
        AssertionUtils.notNull(comparison, "Compare value must not be null");

        Criterion criterion = new Criterion();
        criterion.setField(field);
        criterion.setOperator(Operator.EQUAL);
        criterion.setValue(comparison);
        return criterion;
    }

    public static Criterion notEqual(String field, Object comparison){
        AssertionUtils.notBlank(field, "Field name must not be null");
        AssertionUtils.notNull(comparison, "Compare value must not be null");

        Criterion criterion = new Criterion();
        criterion.setField(field);
        criterion.setOperator(Operator.NOT_EQUAL);
        criterion.setValue(comparison);
        return criterion;
    }

    public static Criterion lessThan(String field, Object comparison){
        AssertionUtils.notBlank(field, "Field name must not be null");
        AssertionUtils.notNull(comparison, "Compare value must not be null");

        Criterion criterion = new Criterion();
        criterion.setField(field);
        criterion.setOperator(Operator.LESS_THAN);
        criterion.setValue(comparison);
        return criterion;
    }

    public static Criterion lessThanOrEqual(String field, Object comparison){
        AssertionUtils.notBlank(field, "Field name must not be null");
        AssertionUtils.notNull(comparison, "Compare value must not be null");

        Criterion criterion = new Criterion();
        criterion.setField(field);
        criterion.setOperator(Operator.LESS_THAN_OR_EQUAL);
        criterion.setValue(comparison);
        return criterion;
    }
}
