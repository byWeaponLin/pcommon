package com.github.weaponlin.selector.basic;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Operator {
    /**
     * 等于
     */
    eq(" = "),
    /**
     * 不等于
     */
    ne(" != "),
    /**
     * 小于
     */
    lt(" < "),
    /**
     * 小于等于
     */
    le(" <= "),
    /**
     * 大于
     */
    gt(" > "),
    /**
     * 大于等于
     */
    ge(" >= "),
    /**
     * in
     */
    in(" in "),
    /**
     * not in
     */
    notin(" not in "),
    /**
     * like
     */
    like(" like "),

    ;

    /**
     * 比较符
     */
    private String op;
}
