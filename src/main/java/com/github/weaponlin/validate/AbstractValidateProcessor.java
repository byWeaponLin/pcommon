package com.github.weaponlin.validate;

import com.github.weaponlin.common.ErrorInfo;
import lombok.NonNull;
import org.springframework.beans.factory.InitializingBean;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static java.util.stream.Collectors.toMap;


public abstract class AbstractValidateProcessor<S, T> implements InitializingBean {

    private List<AdvanceValidator<S, T>> validators;

    public Map<Long, ErrorInfo> doValidate(@NonNull Long userId, @NonNull Long optId,
                                           @NonNull Map<Long, S> sources, @NonNull Map<Long, T> targets) {
        return validators.stream()
                .map(validator -> validator.doValidate(userId, optId, sources, targets))
                .filter(Objects::nonNull)
                .map(Map::entrySet)
                .flatMap(Collection::stream)
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    @Override
    public void afterPropertiesSet() {
        validators = addValidators();
    }

    abstract List<AdvanceValidator<S, T>> addValidators();
}
