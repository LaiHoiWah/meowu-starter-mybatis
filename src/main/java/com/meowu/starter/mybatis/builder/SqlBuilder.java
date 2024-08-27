package com.meowu.starter.mybatis.builder;

import com.meowu.starter.mybatis.criteria.Criteria;

public interface SqlBuilder {

    String find(Criteria criteria);
}
