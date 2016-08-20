package com.dnk.smart.lock.kit;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class ReflectUtil {

    private static Class getClassGenericType(final Class<?> clazz, int index) {
        Type type = clazz.getGenericSuperclass();
        if (!(type instanceof ParameterizedType)) {
            return Object.class;
        }
        Type[] params = ((ParameterizedType) type).getActualTypeArguments();
        if (index >= params.length || index < 0) {
            return Object.class;
        }
        if (!(params[index] instanceof Class)) {
            return Object.class;
        }
        return (Class) params[index];
    }

    public static Class getClassGenericType(final Class<?> clazz) {
        return getClassGenericType(clazz, 0);
    }
}
