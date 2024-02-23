package com.build;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.implementation.bind.annotation.AllArguments;
import net.bytebuddy.implementation.bind.annotation.Origin;
import net.bytebuddy.implementation.bind.annotation.RuntimeType;
import net.bytebuddy.matcher.ElementMatchers;

import java.lang.reflect.Method;

/**
 * @Author dp
 * @Date 2024/2/21
 */
public class ByteBuddyProcess {

    public static void main(String[] args) {
        try {
            Porcess process = new ByteBuddy()
                    .subclass(Porcess.class)
                    .method(ElementMatchers.any())
                    .intercept(MethodDelegation.to(new Interceptor()))
                    .make()
                    .load(Porcess.class.getClassLoader())
                    .getLoaded()
                    .newInstance();

            process.process("123");
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }


    public static class Interceptor {
        @RuntimeType
        public void intercept(@Origin Method method, @AllArguments Object[] args) {
            System.out.println("ByteBuddyProcess Before ");
            System.out.println("Method name: " + method.getName());
            System.out.println("name: " + args[0]);
            System.out.println("ByteBuddyProcess After");
        }
    }
}
