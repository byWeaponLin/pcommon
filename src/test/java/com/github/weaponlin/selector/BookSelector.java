package com.github.weaponlin.selector;

/**
 * 图书查询器
 */
public class BookSelector extends Selector<BookField> {

    {
        for (BookField field : BookField.values()) {
            if (field.isQuery()) {
                queryFields.add(field);
            }
            if (field.isPredicate()) {
                predicateFields.add(field);
            }
            if (field.isOrder()) {
                orderFields.add(field);
            }
        }
    }
}
