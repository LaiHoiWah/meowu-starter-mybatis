package com.meowu.starter.mybatis.provider;

import com.meowu.starter.mybatis.criteria.Criteria;

public class MySqlProvider implements SqlProvider{

    @Override
    public String find(Criteria criteria){
        return """
                <script>
                    SELECT
                    <foreach collection="selects" item="select" separator=",">
                        <choose>
                            <when test="select instanceof Selection">
                                ${select}
                                <if test="select.alias != null and select.alias.equals('')">
                                    as #{select.alias}
                                </if>
                            </when>
                        </choose>
                    </foreach>
                    From
                        ${tableName}
                    <where>
                        <foreach collection="conditions" item="criterion">
                            <trim prefix="AND (" suffix=")">
                                <choose>
                                    <when test="criterion.valueType.name == 'SINGLE'">
                                        ${criterion.column} ${criterion.operator} #{criterion.value}
                                    </when>
                                    <when test="criterion.valueType.name == 'TWINS'">
                                        ${criterion.column} ${criterion.operator}
                                        <foreach collection="criterion.value" item="value" separator=",">
                                            #{value}
                                        </foreach>
                                    </when>
                                    <when test="criterion.valueType.name == 'MULTIPLE'">
                                        ${criterion.column} ${criterion.operator}
                                        <foreach collection="criterion.value" item="value" open="(" close=")" separator=",">
                                            #{value}
                                        </foreach>
                                    </when>
                                    <when test="criterion.valueType.name == 'NONE'">
                                        ${criterion.column} ${criterion.operator}
                                    </when>
                                    <when test="criterion.valueType.name == 'FUNCTION'">
                                        ${criterion.operator}
                                        <foreach collection="criterion.value" item="value" open="(" close=")" separator=",">
                                            #{value}
                                        </foreach>
                                    </when>
                                    <when test="criterion.valueType.name == 'CRITERION'">
                                        <foreach collection="criterion.value" item="item" open="(" close=")" separator="criterion.operator">
                                            <trim prefix="(" suffix=")">
                                                <choose>
                                                    <when test="item.valueType.name == 'SINGLE'">
                                                        ${item.column} ${item.operator} #{item.value}
                                                    </when>
                                                    <when test="item.valueType.name == 'TWINS'">
                                                        ${item.column} ${item.operator}
                                                        <foreach collection="item.value" item="value" separator=",">
                                                            #{value}
                                                        </foreach>
                                                    </when>
                                                    <when test="item.valueType.name == 'MULTIPLE'">
                                                        ${item.column} ${item.operator}
                                                        <foreach collection="item.value" item="value" open="(" close=")" separator=",">
                                                            #{value}
                                                        </foreach>
                                                    </when>
                                                    <when test="item.valueType.name == 'NONE'">
                                                        ${item.column} ${item.operator}
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
