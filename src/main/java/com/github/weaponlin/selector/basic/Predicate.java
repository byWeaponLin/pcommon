package com.github.weaponlin.selector.basic;

import lombok.Data;

import java.util.List;

@Data
public class Predicate<T extends Enum> {

    /**
     * 过滤字段
     */
    private T field;

    /**
     * 比较操作符
     */
    private Operator operator;

    /**
     * 过滤字段集合
     */
    private List<String> values;

    public Object getValue() {
        if (Operator.in == operator || Operator.notin == operator) {
            return values;
        }
        if (Operator.like == operator) {
            return "%" + values.get(0) + "%";
        }
        return values.get(0);
    }
}
