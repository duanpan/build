package com.build;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author dp
 * @Date 2024/2/21
 */
public class JdkAgentProcess implements InvocationHandler {

    private Object target;

    public JdkAgentProcess(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("=======JdkAgentProcess========");
        Object invoke = method.invoke(target, args);
        return invoke;
    }


    public static void main(String[] args) {
        Porcess porcess = (Porcess) Proxy.newProxyInstance(Porcess.class.getClassLoader(),
                new Class[]{Porcess.class}, new JdkAgentProcess(new Porcess() {
                    @Override
                    public void process(String name) {
                        System.out.println(name);
                    }
                }));

        porcess.process("duanpan");
    }
}
