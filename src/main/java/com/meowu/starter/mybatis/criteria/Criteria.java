package com.meowu.starter.mybatis.criteria;

import com.google.common.collect.Lists;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;

@Getter
@Setter
public class Criteria{

    private List<String>    selects;
    private List<Criterion> conditions;

    private Criterion groupBy;
    private Criterion orderBy;
    private Criterion limit;

    public Criteria(){
        this.selects    = Lists.newArrayList();
        this.conditions = Lists.newArrayList();
    }

    public void where(Criterion... conditions){
        this.conditions.addAll(Arrays.stream(conditions).toList());
    }

    public void clearSelects(){
        this.selects.clear();
    }

    public void clearConditions(){
        this.conditions.clear();
    }
}
