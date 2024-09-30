package com.meowu.starter.mybatis.mysql.restrictions;

import com.google.common.collect.Lists;
import com.meowu.starter.mybatis.constants.CriterionType;
import com.meowu.starter.mybatis.constants.Symbol;
import com.meowu.starter.mybatis.constants.ValueType;
import com.meowu.starter.mybatis.criteria.expression.Criterion;
import com.meowu.starter.mybatis.mysql.operator.Operator;

import java.util.List;

public class Restrictions{

    public static Criterion equal(String field, Object comparison){
        Criterion criterion = new Criterion();
        criterion.setField(field);
        criterion.setValue(comparison);
        criterion.setOperator(Operator.EQUAL);
        criterion.setCriterionType(CriterionType.OPERATION);
        criterion.setValueType(ValueType.SINGLE);
        return criterion;
    }

    public static Criterion lessThan(String field, Object comparison){
        Criterion criterion = new Criterion();
        criterion.setField(field);
        criterion.setValue(comparison);
        criterion.setOperator(Operator.LESS_THAN);
        criterion.setCriterionType(CriterionType.OPERATION);
        criterion.setValueType(ValueType.SINGLE);
        return criterion;
    }

    public static Criterion lessThanOrEqual(String field, Object comparison){
        Criterion criterion = new Criterion();
        criterion.setField(field);
        criterion.setValue(comparison);
        criterion.setOperator(Operator.LESS_THAN_OR_EQUAL);
        criterion.setCriterionType(CriterionType.OPERATION);
        criterion.setValueType(ValueType.SINGLE);
        return criterion;
    }

    public static Criterion greaterThan(String field, Object comparison){
        Criterion criterion = new Criterion();
        criterion.setField(field);
        criterion.setValue(comparison);
        criterion.setOperator(Operator.GREATER_THAN);
        criterion.setCriterionType(CriterionType.OPERATION);
        criterion.setValueType(ValueType.SINGLE);
        return criterion;
    }

    public static Criterion greaterThanOrEqual(String field, Object comparison){
        Criterion criterion = new Criterion();
        criterion.setField(field);
        criterion.setValue(comparison);
        criterion.setOperator(Operator.GREATER_THAN_OR_EQUAL);
        criterion.setCriterionType(CriterionType.OPERATION);
        criterion.setValueType(ValueType.SINGLE);
        return criterion;
    }

    public static Criterion notEqual(String field, Object comparison){
        Criterion criterion = new Criterion();
        criterion.setField(field);
        criterion.setValue(comparison);
        criterion.setOperator(Operator.NOT_EQUAL);
        criterion.setCriterionType(CriterionType.OPERATION);
        criterion.setValueType(ValueType.SINGLE);
        return criterion;
    }

    public static Criterion between(String field, Object min, Object max){
        Criterion criterion = new Criterion();
        criterion.setField(field);
        criterion.setValue(Lists.newArrayList(min, max));
        criterion.setOperator(Operator.BETWEEN);
        criterion.setCriterionType(CriterionType.OPERATION);
        criterion.setValueType(ValueType.TWINS);
        return criterion;
    }

    public static Criterion notBetween(String field, Object min, Object max){
        Criterion criterion = new Criterion();
        criterion.setField(field);
        criterion.setValue(Lists.newArrayList(min, max));
        criterion.setOperator(Operator.NOT_BETWEEN);
        criterion.setCriterionType(CriterionType.OPERATION);
        criterion.setValueType(ValueType.TWINS);
        return criterion;
    }

    public static Criterion in(String field, List<?> comparisons){
        Criterion criterion = new Criterion();
        criterion.setField(field);
        criterion.setValue(comparisons);
        criterion.setOperator(Operator.IN);
        criterion.setCriterionType(CriterionType.OPERATION);
        criterion.setValueType(ValueType.MULTIPLE);
        return criterion;
    }

    public static Criterion notIn(String field, List<?> comparisons){
        Criterion criterion = new Criterion();
        criterion.setField(field);
        criterion.setValue(comparisons);
        criterion.setOperator(Operator.NOT_IN);
        criterion.setCriterionType(CriterionType.OPERATION);
        criterion.setValueType(ValueType.MULTIPLE);
        return criterion;
    }

    public static Criterion like(String field, Object comparison){
        Criterion criterion = new Criterion();
        criterion.setField(field);
        criterion.setValue(Symbol.PERCENT + comparison + Symbol.PERCENT);
        criterion.setOperator(Operator.LIKE);
        criterion.setCriterionType(CriterionType.OPERATION);
        criterion.setValueType(ValueType.SINGLE);
        return criterion;
    }

    public static Criterion leftLike(String field, Object comparison){
        Criterion criterion = new Criterion();
        criterion.setField(field);
        criterion.setValue(Symbol.PERCENT + comparison);
        criterion.setOperator(Operator.LIKE);
        criterion.setCriterionType(CriterionType.OPERATION);
        criterion.setValueType(ValueType.SINGLE);
        return criterion;
    }

    public static Criterion rightLike(String field, Object comparison){
        Criterion criterion = new Criterion();
        criterion.setField(field);
        criterion.setValue(comparison + Symbol.PERCENT);
        criterion.setOperator(Operator.LIKE);
        criterion.setCriterionType(CriterionType.OPERATION);
        criterion.setValueType(ValueType.SINGLE);
        return criterion;
    }

    public static Criterion notLike(String field, Object comparison){
        Criterion criterion = new Criterion();
        criterion.setField(field);
        criterion.setValue(Symbol.PERCENT + comparison + Symbol.PERCENT);
        criterion.setOperator(Operator.NOT_LIKE);
        criterion.setCriterionType(CriterionType.OPERATION);
        criterion.setValueType(ValueType.SINGLE);
        return criterion;
    }

    public static Criterion notLeftLike(String field, Object comparison){
        Criterion criterion = new Criterion();
        criterion.setField(field);
        criterion.setValue(Symbol.PERCENT + comparison);
        criterion.setOperator(Operator.NOT_LIKE);
        criterion.setCriterionType(CriterionType.OPERATION);
        criterion.setValueType(ValueType.SINGLE);
        return criterion;
    }

    public static Criterion notRightLike(String field, Object comparison){
        Criterion criterion = new Criterion();
        criterion.setField(field);
        criterion.setValue(comparison + Symbol.PERCENT);
        criterion.setOperator(Operator.NOT_LIKE);
        criterion.setCriterionType(CriterionType.OPERATION);
        criterion.setValueType(ValueType.SINGLE);
        return criterion;
    }

    public static Criterion and(Criterion... conditions){
        Criterion criterion = new Criterion();
        criterion.setValue(conditions);
        criterion.setOperator(Operator.AND);
        criterion.setCriterionType(CriterionType.CRITERION);
        criterion.setValueType(ValueType.MULTIPLE);
        return criterion;
    }

    public static Criterion or(Criterion... conditions){
        Criterion criterion = new Criterion();
        criterion.setValue(conditions);
        criterion.setOperator(Operator.OR);
        criterion.setCriterionType(CriterionType.CRITERION);
        criterion.setValueType(ValueType.MULTIPLE);
        return criterion;
    }
}
