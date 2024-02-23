package com.build;

import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        try {
            System.out.println("===========class has XClass===========");
            testClassScan("com.build",XClass.class);
            System.out.println("");
            System.out.println("===========method has XMethod===========");
            testMethodScan("com.build",XMethod.class);
            System.out.println("");
            System.out.println("");
            System.out.println("===========filed has XFiled===========");
            testFiledScan("com.build",XFiled.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void testMethodScan(String packageName, Class anotation) throws Exception {
        List<AnnotationMethodInfo> methodInfos = AnnotationScanHelper.methodAnnotationScan(packageName,anotation);
        for (AnnotationMethodInfo methodInfo : methodInfos) {
            System.out.print(methodInfo.getClazz().getName()+"  ");
            System.out.print(methodInfo.getMethod().getName() + "  ");
            Class<?>[] parameterTypes = methodInfo.getMethod().getParameterTypes();
            System.out.print("(");
            for (Class<?> parameterType : parameterTypes) {
                System.out.print(parameterType.getName());
            }
            System.out.print(")");
        }
    }

    public static void testFiledScan(String packageName, Class anotation) throws Exception {
        List<AnnotationFieldInfo> fieldInfoList = AnnotationScanHelper.filedAnnotationScan(packageName,anotation);
        for (AnnotationFieldInfo fieldInfo : fieldInfoList) {
            System.out.print(fieldInfo.getClazz().getName()+"  ");
            System.out.print(fieldInfo.getField().getName());
        }
    }

    public static void testClassScan(String packageName, Class anotation) throws Exception {
        List<Class> classes = AnnotationScanHelper.classAnnotationScan(packageName,anotation);
        for (Class aClass : classes) {
            System.out.println(aClass.getName());
        }
    }

}
