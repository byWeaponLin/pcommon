package com.github.weaponlin.validate;

import com.github.weaponlin.common.ErrorInfo;
import com.google.common.collect.Lists;
import lombok.NonNull;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.apache.commons.collections4.CollectionUtils;

import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

@Setter
@Accessors(chain = true)
public class BasicValidator {

    private boolean fastFail = true;

    private List<ErrorInfo> errors = Lists.newArrayList();

    public <T> BasicValidator validate(Predicate<T> function, T param, @NonNull ErrorInfo errorInfo) {
        boolean result = function.test(param);
        if (!result) {
            errors.add(errorInfo);
        }
        if (fastFail && CollectionUtils.isNotEmpty(errors)) {
            throw new BasicValidatorException(errors);
        }
        return this;
    }

    public <T, U> BasicValidator validate(BiPredicate<T, U> function, T param1, U param2,
                                          @NonNull ErrorInfo errorInfo) {
        boolean result = function.test(param1, param2);
        if (!result) {
            errors.add(errorInfo);
        }
        if (fastFail && CollectionUtils.isNotEmpty(errors)) {
            throw new BasicValidatorException(errors);
        }
        return this;
    }

    public void fastFail() {
        if (CollectionUtils.isNotEmpty(errors)) {
            throw new BasicValidatorException(errors);
        }
    }

    /**
     * @return an instance of BasicValidator with fastFail is true
     */
    public static BasicValidator getValidator() {
        return new BasicValidator();
    }

    public static BasicValidator getValidator(boolean fastFail) {
        return new BasicValidator().setFastFail(fastFail);
    }
}
