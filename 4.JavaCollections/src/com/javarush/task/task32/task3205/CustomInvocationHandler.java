package com.javarush.task.task32.task3205;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by USER-PC on 04.10.2017.
 */
public class CustomInvocationHandler implements InvocationHandler {
    private SomeInterfaceWithMethods obj;

    public CustomInvocationHandler(SomeInterfaceWithMethods someInterfaceWithMethods) {
        this.obj = someInterfaceWithMethods;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method.getName() + " in");
        Object out = method.invoke(obj,args);
        System.out.println(method.getName()+ " out");
        return out;
    }
}
