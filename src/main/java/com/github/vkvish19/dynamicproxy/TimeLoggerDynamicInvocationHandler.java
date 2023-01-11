package com.github.vkvish19.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class TimeLoggerDynamicInvocationHandler implements InvocationHandler
{
    private Object target;
    private Map<String, Method> methods = new HashMap<>();
    
    public TimeLoggerDynamicInvocationHandler(Object target)
    {
        this.target = target;
        for(Method method : target.getClass().getDeclaredMethods())
        {
            this.methods.put(method.getName(), method);
        }
    }
    
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
    {
        System.out.println("Inside invoke of " + getClass().getSimpleName() + ".invoke()");
        long startTime = System.nanoTime();
        Object result = methods.get(method.getName()).invoke(target, args);
        long totalTimeTaken = System.nanoTime() - startTime;
        System.out.println("Time taken = " + totalTimeTaken + "nanosec");
        return result;
    }
}
