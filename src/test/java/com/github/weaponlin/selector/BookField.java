package com.github.weaponlin.selector;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BookField {

    id("id", true, true, true),
    name("name", true, true, false),
    price("price", true, true, true),
    author("author", true, true, false),
    press("press", true, true, false),
    isbn("isbn", true, true, false),
    classify("classify", true, true, false),

    ;

    /**
     * db字段
     */
    private String column;

    /**
     * 可查询
     */
    private boolean query;

    /**
     * 可当做条件
     */
    private boolean predicate;

    /**
     * 可排序
     */
    private boolean order;

    public boolean cantQuery() {
        return !this.query;
    }

    public boolean cantPredicate() {
        return !this.predicate;
    }

    public boolean cantOrder() {
        return !this.order;
    }
}
