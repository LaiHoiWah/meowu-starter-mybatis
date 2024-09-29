package com.meowu.starter.mybatis.criteria;

import com.google.common.collect.Lists;
import com.meowu.starter.mybatis.criteria.expression.Criterion;
import com.meowu.starter.mybatis.criteria.expression.Selection;
import com.meowu.starter.mybatis.utils.FieldUtils;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Getter
public class Criteria{

    private String tableName;

    private final List<Selection> selections;
    private final List<Criterion> conditions;

    public Criteria(){
        this.selections = Lists.newArrayList();
        this.conditions = Lists.newArrayList();
    }

    public void from(Class<?> fromType){
        this.tableName = FieldUtils.getTableName(fromType);
    }

    public void select(Selection... selections){
        this.selections.addAll(Arrays.asList(selections));
    }

    public void where(Criterion... conditions){
        this.conditions.addAll(Arrays.asList(conditions));
    }

    public void clearSelect(){
        this.selections.clear();
    }

    public void clearCondition(){
        this.conditions.clear();
    }
}
