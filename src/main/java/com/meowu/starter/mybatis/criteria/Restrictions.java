package com.meowu.starter.mybatis.criteria;

import com.google.common.collect.Lists;
import com.meowu.starter.commons.utils.AssertionUtils;
import com.meowu.starter.mybatis.utils.FieldUtils;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Restrictions{

    public static <T, R> Criterion equal(Function<T, R> getter, Object value){
        return equal(FieldUtils.getColumnName(getter), value);
    }

    public static Criterion equal(String column, Object value){
        AssertionUtils.notNull(column, "Column name must not be null");
        AssertionUtils.notNull(value, "Value must not be null");

        Criterion criterion = new Criterion();
        criterion.setColumn(column);
        criterion.setValue(value);
        criterion.setOperator(Operator.EQUAL);
        criterion.setValueType(ValueType.SINGLE);

        return criterion;
    }

    public static <T, R> Criterion notEqual(Function<T, R> getter, Object value){
        return notEqual(FieldUtils.getColumnName(getter), value);
    }

    public static Criterion notEqual(String column, Object value){
        AssertionUtils.notNull(column, "Column name must not be null");
        AssertionUtils.notNull(value, "Value must not be null");

        Criterion criterion = new Criterion();
        criterion.setColumn(column);
        criterion.setValue(value);
        criterion.setOperator(Operator.NOT_EQUAL);
        criterion.setValueType(ValueType.SINGLE);

        return criterion;
    }

    public static <T, R> Criterion like(Function<T, R> getter, Object value){
        return like(FieldUtils.getColumnName(getter), value);
    }

    public static Criterion like(String column, Object value){
        AssertionUtils.notNull(column, "Column name must not be null");
        AssertionUtils.notNull(value, "Value must not be null");

        Criterion criterion = new Criterion();
        criterion.setColumn(column);
        criterion.setValue(value);
        criterion.setOperator(Operator.LIKE);
        criterion.setValueType(ValueType.SINGLE);

        return criterion;
    }

    public static <T, R> Criterion notLike(Function<T, R> getter, Object value){
        return notLike(FieldUtils.getColumnName(getter), value);
    }

    public static Criterion notLike(String column, Object value){
        AssertionUtils.notNull(column, "Column name must not be null");
        AssertionUtils.notNull(value, "Value must not be null");

        Criterion criterion = new Criterion();
        criterion.setColumn(column);
        criterion.setValue(value);
        criterion.setOperator(Operator.NOT_LIKE);
        criterion.setValueType(ValueType.SINGLE);

        return criterion;
    }

    public static <T, R> Criterion between(Function<T, R> getter, Object min, Object max){
        return between(FieldUtils.getColumnName(getter), min, max);
    }

    public static Criterion between(String column, Object min, Object max){
        AssertionUtils.notNull(column, "Column name must not be null");
        AssertionUtils.notNull(min, "Value must not be null");
        AssertionUtils.notNull(max, "Value must not be null");

        Criterion criterion = new Criterion();
        criterion.setColumn(column);
        criterion.setValue(Lists.newArrayList(min, max));
        criterion.setOperator(Operator.BETWEEN);
        criterion.setValueType(ValueType.TWINS);

        return criterion;
    }

    public static <T, R> Criterion notBetween(Function<T, R> getter, Object min, Object max){
        return notBetween(FieldUtils.getColumnName(getter), min, max);
    }

    public static Criterion notBetween(String column, Object min, Object max){
        AssertionUtils.notNull(column, "Column name must not be null");
        AssertionUtils.notNull(min, "Value must not be null");
        AssertionUtils.notNull(max, "Value must not be null");

        Criterion criterion = new Criterion();
        criterion.setColumn(column);
        criterion.setValue(Lists.newArrayList(min, max));
        criterion.setOperator(Operator.NOT_BETWEEN);
        criterion.setValueType(ValueType.TWINS);

        return criterion;
    }

    public static <T, R, E> Criterion in(Function<T, R> getter, List<E> value){
        return in(FieldUtils.getColumnName(getter), value);
    }

    public static <E> Criterion in(String column, List<E> value){
        AssertionUtils.notNull(column, "Column name must not be null");
        AssertionUtils.notEmpty(value, "Value list must not be null");

        Criterion criterion = new Criterion();
        criterion.setColumn(column);
        criterion.setValue(value);
        criterion.setOperator(Operator.IN);
        criterion.setValueType(ValueType.MULTIPLE);

        return criterion;
    }

    public static <T, R, E> Criterion notIn(Function<T, R> getter, List<E> value){
        return notIn(FieldUtils.getColumnName(getter), value);
    }

    public static <E> Criterion notIn(String column, List<E> value){
        AssertionUtils.notNull(column, "Column name must not be null");
        AssertionUtils.notEmpty(value, "Value list must not be null");

        Criterion criterion = new Criterion();
        criterion.setColumn(column);
        criterion.setValue(value);
        criterion.setOperator(Operator.NOT_IN);
        criterion.setValueType(ValueType.MULTIPLE);

        return criterion;
    }

    public static <T, R> Criterion isNull(Function<T, R> getter){
        return isNull(FieldUtils.getColumnName(getter));
    }

    public static Criterion isNull(String column){
        AssertionUtils.notNull(column, "Column name must not be null");

        Criterion criterion = new Criterion();
        criterion.setColumn(column);
        criterion.setOperator(Operator.IS_NULL);
        criterion.setValueType(ValueType.NONE);

        return criterion;
    }

    public static <T, R> Criterion notNull(Function<T, R> getter){
        return notNull(FieldUtils.getColumnName(getter));
    }

    public static Criterion notNull(String column){
        AssertionUtils.notNull(column, "Column name must not be null");

        Criterion criterion = new Criterion();
        criterion.setColumn(column);
        criterion.setOperator(Operator.NOT_NULL);
        criterion.setValueType(ValueType.NONE);

        return criterion;
    }

    public static Criterion count(){
        return count("*");
    }

    public static Criterion count(String... columns){
        AssertionUtils.notEmpty(columns, "Column list must not be null");

        Criterion criterion = new Criterion();
        criterion.setValue(Arrays.stream(columns).toList());
        criterion.setOperator(Operator.COUNT);
        criterion.setValueType(ValueType.FUNCTION);

        return criterion;
    }

    public static Criterion groupBy(String... columns){
        AssertionUtils.notEmpty(columns, "Columns list must not be null");

        Criterion criterion = new Criterion();
        criterion.setValue(Arrays.stream(columns).collect(Collectors.toList()));
        criterion.setOperator(Operator.GROUP_BY);
        criterion.setValueType(ValueType.MULTIPLE);

        return criterion;
    }

    public static Criterion limit(int offset, int size){
        AssertionUtils.isTrue(offset >= 0, "Limit offset must be equal or greater than 0");
        AssertionUtils.isTrue(size > 0, "Limit size must be greater than 0");

        Criterion criterion = new Criterion();
        criterion.setValue(Lists.newArrayList(offset, size));
        criterion.setOperator(Operator.LIMIT);
        criterion.setValueType(ValueType.TWINS);

        return criterion;
    }

    public static Criterion orderBy(Criterion... orders){
        AssertionUtils.notEmpty(orders, "Order array must not be null");

        Criterion criterion = new Criterion();
        criterion.setValue(Arrays.stream(orders).collect(Collectors.toList()));
        criterion.setOperator(Operator.ORDER_BY);
        criterion.setValueType(ValueType.CRITERION);

        return criterion;
    }

    public static <T, R> Criterion asc(Function<T, R> getter){
        return asc(FieldUtils.getColumnName(getter));
    }

    public static Criterion asc(String column){
        AssertionUtils.notNull(column, "Column name must not be null");

        Criterion criterion = new Criterion();
        criterion.setColumn(column);
        criterion.setOperator(Operator.ASC);
        criterion.setValueType(ValueType.NONE);

        return criterion;
    }

    public static <T, R> Criterion desc(Function<T, R> getter){
        return desc(FieldUtils.getColumnName(getter));
    }

    public static Criterion desc(String column){
        AssertionUtils.notNull(column, "Column name must not be null");

        Criterion criterion = new Criterion();
        criterion.setColumn(column);
        criterion.setOperator(Operator.DESC);
        criterion.setValueType(ValueType.NONE);

        return criterion;
    }

    public static <T, R> Criterion select(Function<T, R> getter){
        return select(FieldUtils.getColumnName(getter));
    }

    public static Criterion select(String column){
        AssertionUtils.notNull(column, "Column name must not be null");

        Criterion criterion = new Criterion();
        criterion.setColumn(column);
        criterion.setValueType(ValueType.NONE);
        return criterion;
    }
}
