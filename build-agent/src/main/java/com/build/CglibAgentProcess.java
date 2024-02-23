package com.build;


import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author dp
 * @Date 2024/2/21
 */
public class CglibAgentProcess {

    public static void main(String[] args) {
        Enhancer enhancer=new Enhancer();
        enhancer.setSuperclass(ProcessImpl.class);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("============EnhancerAgentProcess========");
                Object invoke = methodProxy.invokeSuper(o,objects);
                return invoke;
            }
        });

        Porcess porcess =(Porcess)enhancer.create();
        porcess.process("123");
    }



}
