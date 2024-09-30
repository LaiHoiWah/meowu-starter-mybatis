package com.meowu.starter.mybatis.mysql.provider;

import com.meowu.starter.mybatis.criteria.Criteria;

public class Provider{

    public String find(Criteria criteria){
        return
            """
            <script>
                SELECT
                    <choose>
                        <when test="selections.isEmpty()">
                            *
                        </when>
                        <when>
                            <foreach collection="selections" item="selection" separator=",">
                                ${selection.field}
                                <if test="selection.alias != null and selection.alias != ''">
                                    AS #{selection.alias}
                                </if>
                            </foreach>
                        </when>
                    </choose>
                FROM
                    ${tableName}
                <where>
                    <foreach collection="conditions" item="criterion">
                        <trim prefix="AND (" suffix=")">
                            <choose>
                                <when test="criterion.criterionType == 'OPERATION'">
                                    ${criterion.field} ${criterion.operator}
                                    <if test="criterion.valueType == 'SINGLE'">
                                        #{criterion.value}
                                    </if>
                                    <if test="criterion.valueType == 'TWINS'">
                                        <foreach collection="criterion.value" item="value" separator=",">
                                            #{value}
                                        </foreach>
                                    </if>
                                    <if test="criterion.valueType == 'MULTIPLE'">
                                        <foreach collection="criterion.value" item="value" open="(" close=")" separator=",">
                                            #{value}
                                        </foreach>
                                    </if>
                                </when>
                                <when test="criterion.criterionType == 'CRITERION'">
                                    <foreach collection="criterion.value" item="item" open="(" close=")" separator="criterion.operator">
                                        <trim prefix="(" suffix=")">
                                            <choose>
                                                <when test="item.criterionType == 'OPERATION'">
                                                    ${item.field} ${item.operator}
                                                    <if test="item.valueType == 'SINGLE'">
                                                        #{item.value}
                                                    </if>
                                                    <if test="item.valueType == 'TWINS'">
                                                        <foreach collection="item.value" item="value" separator=",">
                                                            #{value}
                                                        </foreach>
                                                    </if>
                                                    <if test="item.valueType == 'MULTIPLE'">
                                                        <foreach collection="item.value" item="value" open="(" close=")" separator=",">
                                                            #{value}
                                                        </foreach>
                                                    </if>
                                                </when>
                                            </choose>
                                        </trim>
                                    </foreach>
                                </when>
                            </choose>
                        </trim>
                    </foreach>
                </where>
            </script>
            """;
    }
}
