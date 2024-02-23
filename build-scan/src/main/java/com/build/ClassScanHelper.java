package com.build;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author dp
 * @Date 2024/2/23
 */

public class ClassScanHelper {


    public static List<Class> classAnnotationScan(String packageName, Class anotation) throws ClassNotFoundException {
        //获取对应包下的所有class
        List<Class> classList = loadClassFormPackage(packageName);
        if (!classList.isEmpty()) {
            //过滤自身为注解和未包含anotation的class
            return classList.stream().filter(c -> !c.isAnnotation() && c.isAnnotationPresent(anotation)).collect(Collectors.toList());
        }
        return null;
    }


    public static List<Class> loadClassFormPackage(String packageName) throws ClassNotFoundException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        String path = packageName.replace(".", "/");
        URL resource = classLoader.getResource(path);
        if (resource == null) {
            throw new RuntimeException(packageName + "包不存在");
        }
        File file = new File(resource.getFile());
        return loadClassFromFile(packageName, file);
    }


    public static List<Class> loadClassFromFile(String packageName, File file) throws ClassNotFoundException {
        ArrayList<Class> classFileList = new ArrayList();
        //文件夹
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File sfile : files) {
                String currenPackageName = sfile.isDirectory() ? packageName.concat(".").concat(sfile.getName()) : packageName;
                List<Class> sfileList = loadClassFromFile(currenPackageName, sfile);
                if (sfileList != null && sfileList.size() > 0) {
                    classFileList.addAll(sfileList);
                }
            }
            return classFileList;
        }

        //class
        if (file.isFile() && file.getName().endsWith(".class")) {
            String className = packageName.concat(".").concat(file.getName()).replace(".class", "");
            Class<?> aClass = Class.forName(className);
            classFileList.add(aClass);
        }

        return classFileList;
    }


}
