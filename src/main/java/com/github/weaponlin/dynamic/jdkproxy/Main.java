package com.github.weaponlin.dynamic.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Main {

    public static void main(String[] args) {
        Actor huge = new HugeActor();
        InvocationHandler handler = new AgentInvocationHandler(huge);
        Actor agent = (Actor) Proxy.newProxyInstance(huge.getClass().getClassLoader(),
                huge.getClass().getInterfaces(),
                handler);
        agent.promotion();
        agent.schedule();
    }
}
