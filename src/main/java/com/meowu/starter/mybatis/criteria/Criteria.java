package com.meowu.starter.mybatis.criteria;

import com.google.common.collect.Lists;
import com.meowu.starter.commons.utils.ArrayUtils;
import com.meowu.starter.commons.utils.CollectionUtils;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Getter
public class Criteria{

    private final List<Selection> selects    = Lists.newArrayList();
    private final List<Criterion> conditions = Lists.newArrayList();

    public Criteria selects(Selection... selectors){
        if(ArrayUtils.isNotEmpty(selectors)){
            this.selects.addAll(Arrays.stream(selectors).toList());
        }
        return this;
    }

    public Criteria where(Criterion... conditions){
        if(ArrayUtils.isNotEmpty(conditions)){
            this.conditions.addAll(Arrays.stream(conditions).toList());
        }
        return this;
    }

    public void clearSelects(){
        this.selects.clear();
    }

    public void clearConditions(){
        this.conditions.clear();
    }
}
