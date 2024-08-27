package com.meowu.starter.mybatis.provider;

import com.meowu.starter.commons.utils.CollectionUtils;
import com.meowu.starter.commons.utils.ObjectUtils;
import com.meowu.starter.mybatis.criteria.Criteria;
import com.meowu.starter.mybatis.criteria.Criterion;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;

public class MySqlProvider implements SqlProvider{

    @Override
    public String find(Criteria criteria){
        SQL sql = new SQL();

        // select
        List<String> selects = criteria.getSelects();
        if(CollectionUtils.isNotEmpty(selects)){
            sql.SELECT(selects.toArray(String[]::new));
        }else{
            sql.SELECT("*");
        }

        // where
        List<Criterion> conditions = criteria.getConditions();
        if(CollectionUtils.isNotEmpty(conditions)){
            String script = """
                        <foreach collection="criteria.conditions" item="criterion">
                            <trim prefix="AND (" suffix=")">
                                <choose>
                                    <when test="criterion.valueType.name == 'SINGLE'">
                                        ${criterion.field} ${criterion.operator} #{criterion.value}
                                    </when>
                                    <when test="criterion.valueType.name == 'TWINS'">
                                        ${criterion.field} ${criterion.operator}
                                        <foreach collection="criterion.value" item="value" separator=",">
                                            #{value}
                                        </foreach>
                                    </when>
                                    <when test="criterion.valueType.name == 'MULTIPLE'">
                                        ${criterion.field} ${criterion.operator}
                                        <foreach collection="criterion.value" item="value" open="(" close=")" separator=",">
                                            #{value}
                                        </foreach>
                                    </when>
                                    <when test="criterion.valueType.name == 'NONE'">
                                        ${criterion.field} ${criterion.operator}
                                    </when>
                                    <when test="criterion.valueType.name == 'CRITERION'">
                                        <foreach collection="criterion.value" item="item" open="(" close=")" separator="criterion.operator">
                                            <trim prefix="(" suffix=")">
                                                <choose>
                                                    <when test="item.valueType.name == 'SINGLE'">
                                                        ${item.field} ${item.operator} #{item.value}
                                                    </when>
                                                    <when test="item.valueType.name == 'TWINS'>
                                                        ${item.field} ${item.operator}
                                                        <foreach collection="item.value" item="value" separator=",">
                                                            #{value}
                                                        </foreach>
                                                    </when>
                                                    <when test="item.valueType.name == 'MULTIPLE'">
                                                        ${item.field} ${item.operator}
                                                        <foreach collection="item.value" item="value" open="(" close=")" separator=",">
                                                            #{value}
                                                        </foreach>
                                                    </when>
                                                    <when test="item.valueType.name == 'NONE'">
                                                        ${item.field} ${item.operator}
                                                    </when>
                                                </choose>
                                            </trim>
                                        </foreach>
                                    </when>
                                </choose>
                            </trim>
                        </foreach>
                    """;

            sql.WHERE(script);
        }

        // order by
        Criterion orderBy = criteria.getOrderBy();
        if(ObjectUtils.isNotNull(orderBy)){
            String script = """
                        <foreach collection="criteria.orderBy.value" item="sort" separator=",">
                            ${sort.field} ${sort.operator}
                        </foreach>
                    """;

            sql.ORDER_BY(script);
        }

        // limit
        Criterion limit = criteria.getLimit();
        if(ObjectUtils.isNotNull(limit)){
            String script = """
                        <foreach collection="criteria.limit.value" item="limit" separator=",">
                            ${limit}
                        </foreach>
                    """;

            sql.LIMIT(script);
        }

        // group by
        Criterion groupBy = criteria.getGroupBy();
        if(ObjectUtils.isNotNull(groupBy)){
            String script = """
                        <foreach collection="criteria.groupBy.value" item="group" separator=",">
                            ${group}
                        </foreach>
                    """;

            sql.GROUP_BY(script);
        }

        return "<script>" + sql.toString() + "</script>";
    }
}
