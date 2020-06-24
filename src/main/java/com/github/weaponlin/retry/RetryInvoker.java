package com.github.weaponlin.retry;

import com.github.weaponlin.function.Functions;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RetryInvoker {

    public static <T1, R> R work(Functions.Function<T1, R> function, T1 t1, int retryTimes) {
        if (retryTimes <= 0) {
            throw new RuntimeException("retry time must be greater than 0");
        }
        for (int i = 0; i < retryTimes; i++) {
            try {
                return function.apply(t1);
            } catch (Exception e) {
                log.warn("execute failed, current: {}, times: {}", i, retryTimes, e);
            }
        }
        throw new RuntimeException("execute method failed after retry");
    }

    public static <T1, T2, R> R work(Functions.BiFunction<T1, T2, R> function, T1 t1, T2 t2, int retryTimes) {
        if (retryTimes <= 0) {
            throw new RuntimeException("retry time must be greater than 0");
        }
        for (int i = 0; i < retryTimes; i++) {
            try {
                return function.apply(t1, t2);
            } catch (Exception e) {
                log.warn("execute failed, current: {}, times: {}", i, retryTimes, e);
            }
        }
        throw new RuntimeException("execute method failed after retry");
    }

    public static <T1, T2, T3, R> R work(Functions.TriFunction<T1, T2, T3, R> function,
                                         T1 t1, T2 t2, T3 t3,
                                         int retryTimes) {
        if (retryTimes <= 0) {
            throw new RuntimeException("retry time must be greater than 0");
        }
        for (int i = 0; i < retryTimes; i++) {
            try {
                return function.apply(t1, t2, t3);
            } catch (Exception e) {
                log.warn("execute failed, current: {}, times: {}", i, retryTimes, e);
            }
        }
        throw new RuntimeException("execute method failed after retry");
    }

    public static <T1, T2, T3, T4, R> R work(Functions.FouFunction<T1, T2, T3, T4, R> function,
                                             T1 t1, T2 t2, T3 t3, T4 t4,
                                             int retryTimes) {
        if (retryTimes <= 0) {
            throw new RuntimeException("retry time must be greater than 0");
        }
        for (int i = 0; i < retryTimes; i++) {
            try {
                return function.apply(t1, t2, t3, t4);
            } catch (Exception e) {
                log.warn("execute failed, current: {}, times: {}", i, retryTimes, e);
            }
        }
        throw new RuntimeException("execute method failed after retry");
    }

    public static <T1, T2, T3, T4, T5, R> R work(Functions.FivFunction<T1, T2, T3, T4, T5, R> function,
                                                 T1 t1, T2 t2, T3 t3, T4 t4, T5 t5,
                                                 int retryTimes) {
        if (retryTimes <= 0) {
            throw new RuntimeException("retry time must be greater than 0");
        }
        for (int i = 0; i < retryTimes; i++) {
            try {
                return function.apply(t1, t2, t3, t4, t5);
            } catch (Exception e) {
                log.warn("execute failed, current: {}, times: {}", i, retryTimes, e);
            }
        }
        throw new RuntimeException("execute method failed after retry");
    }

    public static <T1, T2, T3, T4, T5, T6, R> R work(Functions.SixFunction<T1, T2, T3, T4, T5, T6, R> function,
                                                     T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6,
                                                     int retryTimes) {
        if (retryTimes <= 0) {
            throw new RuntimeException("retry time must be greater than 0");
        }
        for (int i = 0; i < retryTimes; i++) {
            try {
                return function.apply(t1, t2, t3, t4, t5, t6);
            } catch (Exception e) {
                log.warn("execute failed, current: {}, times: {}", i, retryTimes, e);
            }
        }
        throw new RuntimeException("execute method failed after retry");
    }

    public static <T1, T2, T3, T4, T5, T6, T7, R> R work(Functions.SevFunction<T1, T2, T3, T4, T5, T6, T7, R> function,
                                                         T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7,
                                                         int retryTimes) {
        if (retryTimes <= 0) {
            throw new RuntimeException("retry time must be greater than 0");
        }
        for (int i = 0; i < retryTimes; i++) {
            try {
                return function.apply(t1, t2, t3, t4, t5, t6, t7);
            } catch (Exception e) {
                log.warn("execute failed, current: {}, times: {}", i, retryTimes, e);
            }
        }
        throw new RuntimeException("execute method failed after retry");
    }
}
