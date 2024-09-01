package com.github.weaponlin.dynamic.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class AgentInvocationHandler implements InvocationHandler {

    private Object realObject;

    public AgentInvocationHandler(Object object) {
        this.realObject = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Before method invoke, method: " + method.getName());
        Object result = method.invoke(realObject, args);
        System.out.println("After method invoke, method: " + method.getName());
        return result;
    }
}
