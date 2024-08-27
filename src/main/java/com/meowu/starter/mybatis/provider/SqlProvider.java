package com.meowu.starter.mybatis.provider;

import com.meowu.starter.mybatis.criteria.Criteria;

public interface SqlProvider{

    String find(Criteria criteria);
}
