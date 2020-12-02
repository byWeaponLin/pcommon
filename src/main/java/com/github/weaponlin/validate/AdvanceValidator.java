package com.github.weaponlin.validate;

import com.baidu.fengchao.vision.api.common.ApiError;
import lombok.NonNull;
import org.apache.commons.collections4.MapUtils;

import java.util.Map;
import java.util.Set;

/**
 * TODO
 */
public abstract class AdvanceValidator<S, T> {

    public abstract Map<Long, ApiError> validate(@NonNull Long userId, @NonNull Long optId,
                                                 @NonNull Map<Long, S> sources, @NonNull Map<Long, T> targets);

    Map<Long, ApiError> doValidate(@NonNull Long userId, @NonNull Long optId,
                                   @NonNull Map<Long, S> sources, @NonNull Map<Long, T> targets) {
        if (MapUtils.isNotEmpty(sources)) {
            return validate(userId, optId, sources, targets);
        }
        return null;
    }

    protected void removeInvalidItem(Map<Long, ApiError> errors, Map<Long, S> sources, Map<Long, T> targets) {
        if (MapUtils.isEmpty(errors)) {
            return;
        }
        Set<Long> keys = errors.keySet();

        // remove invalid item
        sources.keySet().removeAll(keys);
        targets.keySet().removeAll(keys);
    }
}
