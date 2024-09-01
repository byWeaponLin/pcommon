package com.github.weaponlin.dynamic.cglib;

import com.github.weaponlin.dynamic.jdkproxy.Actor;
import com.github.weaponlin.dynamic.jdkproxy.HugeActor;
import net.sf.cglib.proxy.Enhancer;

public class Main {

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(HugeActor.class);
        enhancer.setCallback(new ActorInterceptor());
        Actor actor = (Actor) enhancer.create();
        actor.promotion();
        actor.schedule();
    }
}
