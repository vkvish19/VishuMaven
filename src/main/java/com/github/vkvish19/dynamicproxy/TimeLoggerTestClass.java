package com.github.vkvish19.dynamicproxy;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class TimeLoggerTestClass
{
    @SuppressWarnings("unchecked")
    public static void main(String[] args)
    {
        Map<String, String> map = (Map<String, String>)Proxy.newProxyInstance(TimeLoggerTestClass.class.getClassLoader(),
                new Class[]{Map.class}, new TimeLoggerDynamicInvocationHandler(new HashMap<>()));
        map.put("Vishu", "test");
        
        CharSequence cs = (CharSequence)Proxy.newProxyInstance(TimeLoggerTestClass.class.getClassLoader(),
                new Class[] {CharSequence.class}, new TimeLoggerDynamicInvocationHandler("Hello Guys!!"));
        cs.length();
    }
}
