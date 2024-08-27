package com.meowu.starter.mybatis.criteria;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Restrictions{

    public static Criterion equal(String field, Object value){
        Criterion criterion = new Criterion();
        criterion.setField(field);
        criterion.setValue(value);
        criterion.setOperator(Operator.EQUAL);
        criterion.setValueType(ValueType.SINGLE);

        return criterion;
    }

    public static Criterion notEqual(String field, Object value){
        Criterion criterion = new Criterion();
        criterion.setField(field);
        criterion.setValue(value);
        criterion.setOperator(Operator.NOT_EQUAL);
        criterion.setValueType(ValueType.SINGLE);

        return criterion;
    }

    public static Criterion like(String field, Object value){
        Criterion criterion = new Criterion();
        criterion.setField(field);
        criterion.setValue(value);
        criterion.setOperator(Operator.LIKE);
        criterion.setValueType(ValueType.SINGLE);

        return criterion;
    }

    public static Criterion notLike(String field, Object value){
        Criterion criterion = new Criterion();
        criterion.setField(field);
        criterion.setValue(value);
        criterion.setOperator(Operator.NOT_LIKE);
        criterion.setValueType(ValueType.SINGLE);

        return criterion;
    }

    public static Criterion between(String field, Object min, Object max){
        Criterion criterion = new Criterion();
        criterion.setField(field);
        criterion.setValue(Lists.newArrayList(min, max));
        criterion.setOperator(Operator.BETWEEN);
        criterion.setValueType(ValueType.TWINS);

        return criterion;
    }

    public static Criterion notBetween(String field, Object min, Object max){
        Criterion criterion = new Criterion();
        criterion.setField(field);
        criterion.setValue(Lists.newArrayList(min, max));
        criterion.setOperator(Operator.NOT_BETWEEN);
        criterion.setValueType(ValueType.TWINS);

        return criterion;
    }

    public static <E> Criterion in(String field, List<E> value){
        Criterion criterion = new Criterion();
        criterion.setField(field);
        criterion.setValue(value);
        criterion.setOperator(Operator.IN);
        criterion.setValueType(ValueType.MULTIPLE);

        return criterion;
    }

    public static <E> Criterion notIn(String field, List<E> value){
        Criterion criterion = new Criterion();
        criterion.setField(field);
        criterion.setValue(value);
        criterion.setOperator(Operator.NOT_IN);
        criterion.setValueType(ValueType.MULTIPLE);

        return criterion;
    }

    public static Criterion isNull(String field){
        Criterion criterion = new Criterion();
        criterion.setField(field);
        criterion.setOperator(Operator.IS_NULL);
        criterion.setValueType(ValueType.NONE);

        return criterion;
    }

    public static Criterion notNull(String field){
        Criterion criterion = new Criterion();
        criterion.setField(field);
        criterion.setOperator(Operator.NOT_NULL);
        criterion.setValueType(ValueType.NONE);

        return criterion;
    }

    public static Criterion groupBy(String... fields){
        Criterion criterion = new Criterion();
        criterion.setValue(Arrays.stream(fields).collect(Collectors.toList()));
        criterion.setOperator(Operator.GROUP_BY);
        criterion.setValueType(ValueType.MULTIPLE);

        return criterion;
    }

    public static Criterion limit(int offset, int size){
        Criterion criterion = new Criterion();
        criterion.setValue(Lists.newArrayList(offset, size));
        criterion.setOperator(Operator.LIMIT);
        criterion.setValueType(ValueType.TWINS);

        return criterion;
    }

    public static Criterion orderBy(Criterion... orders){
        Criterion criterion = new Criterion();
        criterion.setValue(Arrays.stream(orders).collect(Collectors.toList()));
        criterion.setOperator(Operator.ORDER_BY);
        criterion.setValueType(ValueType.CRITERION);

        return criterion;
    }

    public static Criterion asc(String field){
        Criterion criterion = new Criterion();
        criterion.setField(field);
        criterion.setOperator(Operator.ASC);
        criterion.setValueType(ValueType.NONE);

        return criterion;
    }

    public static Criterion desc(String field){
        Criterion criterion = new Criterion();
        criterion.setField(field);
        criterion.setOperator(Operator.DESC);
        criterion.setValueType(ValueType.NONE);

        return criterion;
    }
}
