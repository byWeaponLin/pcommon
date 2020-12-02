package com.github.weaponlin.selector;

import com.github.weaponlin.selector.basic.OrderBy;
import com.github.weaponlin.selector.basic.Page;
import com.github.weaponlin.selector.basic.Predicate;
import com.google.common.collect.Sets;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Set;

@ToString
public abstract class Selector<T extends Enum> {

    @Getter
    @Setter
    private List<T> fields;

    @Getter
    @Setter
    private Page page;

    @Getter
    @Setter
    private List<Predicate<T>> predicates;

    @Getter
    @Setter
    private OrderBy<T> orderBy;

    protected Set<T> queryFields = Sets.newHashSet();

    protected Set<T> predicateFields = Sets.newHashSet();

    protected Set<T> orderFields = Sets.newHashSet();


    private boolean canQuery(T t) {
        return queryFields.contains(t);
    }

    private boolean canPredicate(T t) {
        return predicateFields.contains(t);
    }


    private boolean canOrder(T t) {
        return orderFields.contains(t);
    }

    /**
     * 校验
     *
     * @return true: 成功
     * false: 失败
     */
    public boolean validate() {

        // validate select fields
        if (fields != null && fields.size() > 0) {
            for (T field : fields) {
                if (field == null) {
                    return false;
                } else if (!canQuery(field)) {
                    return false;
                }
            }
        }

        // validate predicate
        if (predicates != null && predicates.size() > 0) {
            for (Predicate<T> predicate : predicates) {
                if (predicate == null) {
                    return false;
                }
                T field = predicate.getField();
                if (field == null) {
                    return false;
                } else if (!canPredicate(field)) {
                    return false;
                }
                if (predicate.getOperator() == null) {
                    return false;
                }
                if (predicate.getValues() == null || predicate.getValues().size() < 1) {
                    return false;
                }
            }
        }

        // validate order by
        if (orderBy != null) {
            T field = orderBy.getField();
            if (field == null) {
                return false;
            } else if (!canOrder(field)) {
                return false;
            }
        }

        if (page != null) {
            Integer offset = page.getOffset();
            Integer numbers = page.getNumbers();
            if (offset == null || offset < 0) {
                return false;
            }
            if (numbers == null || numbers <= 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 校验，失败会抛出异常
     */
    public void validateThrow() {

        // validate select fields
        if (fields != null && fields.size() > 0) {
            for (T field : fields) {
                if (field == null) {
                    throw new RuntimeException("查询字段不能为空");
                } else if (!canQuery(field)) {
                    throw new RuntimeException("字段不支持查询");
                }
            }
        }

        // validate predicate
        if (predicates != null && predicates.size() > 0) {
            for (Predicate<T> predicate : predicates) {
                if (predicate == null) {
                    throw new RuntimeException("查询条件不能为空");
                }
                T field = predicate.getField();
                if (field == null) {
                    throw new RuntimeException("查询条件字段不能为空");
                } else if (!canPredicate(field)) {
                    throw new RuntimeException("字段不支持当做查询条件");
                }
                if (predicate.getOperator() == null) {
                    throw new RuntimeException("查询操作符不能为空");
                }
                if (predicate.getValues() == null || predicate.getValues().size() < 1) {
                    throw new RuntimeException("查询值不能为空");
                }
            }
        }

        // validate order by
        if (orderBy != null) {
            T field = orderBy.getField();
            if (field == null) {
                throw new RuntimeException("排序字段不能为空");
            } else if (!canOrder(field)) {
                throw new RuntimeException("字段不支持排序");
            }
        }

        if (page != null) {
            Integer offset = page.getOffset();
            Integer numbers = page.getNumbers();
            if (offset == null || offset < 0) {
                throw new RuntimeException("偏移量不能为空或小于0");
            }
            if (numbers == null || numbers <= 0) {
                throw new RuntimeException("记录条数不能为空或小于等于0");
            }
        }
    }
}
