package com.github.weaponlin.selector.basic;

import lombok.Data;

/**
 * TODO 修改为接口，支持offset 和 页码两种方式
 */
@Data
public class Page {

    /**
     * 起始偏移量
     */
    private Integer offset;

    /**
     * 本页返回的记录条数
     */
    private Integer numbers;
}
