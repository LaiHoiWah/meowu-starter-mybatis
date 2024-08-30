package com.meowu.starter.mybatis.criteria;

import com.google.common.collect.Lists;
import com.meowu.starter.commons.utils.ArrayUtils;
import com.meowu.starter.commons.utils.CollectionUtils;
import com.meowu.starter.mybatis.utils.FieldUtils;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;

@Getter
@Setter
public class Criteria{

    private final static List<Criterion> ALL_SELECTS = Lists.newArrayList(Criterion.builder().column("*").build());

    private List<Criterion> selects;
    private List<Criterion> conditions;

    private String    tableName;
    private Criterion groupBy;
    private Criterion orderBy;
    private Criterion limit;

    public Criteria(String tableName){
        this.tableName  = tableName;
        this.selects    = Lists.newArrayList();
        this.conditions = Lists.newArrayList();
    }

    public Criteria(Class<?> classOf){
        this.tableName  = FieldUtils.getTableName(classOf);
        this.selects    = Lists.newArrayList();
        this.conditions = Lists.newArrayList();
    }

    public void selects(Criterion... columns){
        if(ArrayUtils.isNotEmpty(columns)){
            this.selects.addAll(Arrays.stream(columns).toList());
        }
    }

    public void where(Criterion... conditions){
        if(ArrayUtils.isNotEmpty(conditions)){
            this.conditions.addAll(Arrays.stream(conditions).toList());
        }
    }

    public void clearSelects(){
        this.selects.clear();
    }

    public void clearConditions(){
        this.conditions.clear();
    }

    public List<Criterion> getSelects(){
        return CollectionUtils.isEmpty(this.selects) ? ALL_SELECTS : this.selects;
    }
}
