package com.meowu.starter.mybatis.criteria;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Criterion{

    private String column;
    private String operator;
    private Object value;
    private ValueType valueType;
}
