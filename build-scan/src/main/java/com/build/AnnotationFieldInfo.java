package com.build;

import java.lang.reflect.Field;

/**
 * @Author dp
 * @Date 2024/2/23
 */
public class AnnotationFieldInfo {
    public AnnotationFieldInfo(Class clazz, Field field) {
        this.clazz = clazz;
        this.field = field;
    }

    private Class clazz;

    private Field field;

    public Class getClazz() {
        return clazz;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }
}
