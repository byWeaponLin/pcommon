package com.github.weaponlin.dynamic.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class ActorInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("Before method invoke, method: " + method.getName());
        Object result = proxy.invokeSuper(obj, args);
        System.out.println("After method invoke, method: " + method.getName());
        return result;
    }
}
