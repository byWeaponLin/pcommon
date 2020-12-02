package com.github.weaponlin.selector.basic;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public enum Order {

    asc,
    desc,

    ;

    public static boolean isValid(String order) {
        try {
            Order.valueOf(order);
            return true;
        } catch (Exception e) {
            log.error("invalid order, order: {}", order);
        }
        return false;
    }
}
