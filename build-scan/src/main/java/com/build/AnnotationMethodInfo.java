package com.build;

import java.lang.reflect.Method;

public class AnnotationMethodInfo {

        public AnnotationMethodInfo(Class clazz, Method method) {
            this.clazz = clazz;
            this.method = method;
        }

        private Class clazz;

        private Method method;

        public Class getClazz() {
            return clazz;
        }

        public void setClazz(Class clazz) {
            this.clazz = clazz;
        }

        public Method getMethod() {
            return method;
        }

        public void setMethod(Method method) {
            this.method = method;
        }
    }