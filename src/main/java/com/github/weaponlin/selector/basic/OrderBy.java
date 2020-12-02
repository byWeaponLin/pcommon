package com.github.weaponlin.selector.basic;

import lombok.Data;

@Data
public class OrderBy<T extends Enum> {

    /**
     * 排序筛选字段
     */
    private T field;

    /**
     * 排序规则
     */
    private Order order;
}
