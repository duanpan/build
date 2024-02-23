package com.build;

import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        try {
            List<Class> classes = ClassScanHelper.classAnnotationScan("com.build", XClass.class);
            for (Class aClass : classes) {
                System.out.println(aClass.getName());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
