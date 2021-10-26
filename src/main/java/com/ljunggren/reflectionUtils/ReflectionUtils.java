package com.ljunggren.reflectionUtils;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

import org.apache.commons.lang3.reflect.FieldUtils;

public class ReflectionUtils {

    public static Type getOwnerType(Type type) {
        return type instanceof ParameterizedType ? ((ParameterizedType) type).getRawType() : null;
    }
    
    public static boolean isParameterized(Type type) {
        return type instanceof ParameterizedType;
    }
    
    public static Type[] getParameterizedTypes(Type type) {
        if (type instanceof ParameterizedType) {
            return ((ParameterizedType) type).getActualTypeArguments();
        }
        return new Type[] {};
    }
    
    public static Type getParameterizedType(Type type) {
        Type[] types = getParameterizedTypes(type);
        return types.length == 1 ? types[0] : null;
    }
    
    public static Type getArrayComponentType(Type type) {
        return isArray(type) ? ((Class<?>) type).getComponentType() : null;
    }
    
    public static List<Field> getObjectFields(Class<?> clazz) {
        return FieldUtils.getAllFieldsList(clazz);
    }
    
    public static boolean isPrimitive(Type type) {
        if (isParameterized(type)) {
            return false;
        }
        return isPrimitive((Class<?>) type);
    }
    
    public static boolean isPrimitive(Class<?> clazz) {
        return clazz.isPrimitive();
    }
    
    public static boolean isNumber(Type type) {
        if (isParameterized(type)) {
            return false;
        }
        return isNumber((Class<?>) type);
     }
    
    public static boolean isNumber(Class<?> clazz) {
        return Number.class.isAssignableFrom(clazz);
    }
    
    public static boolean isInteger(Type type) {
        if (isParameterized(type)) {
            return false;
        }
        return isInteger((Class<?>) type);
    }
    
    public static boolean isInteger(Class<?> clazz) {
        return Integer.class.getName().equals(clazz.getName());
    }
    
    public static boolean isDouble(Type type) {
        if (isParameterized(type)) {
            return false;
        }
        return isDouble((Class<?>) type);
    }
    
    public static boolean isDouble(Class<?> clazz) {
        return Double.class.getName().equals(clazz.getName());
    }
    
    public static boolean isString(Type type) {
        if (isParameterized(type)) {
            return false;
        }
        return isString((Class<?>) type);
    }
    
    public static boolean isString(Class<?> clazz) {
        return String.class.getName().equals(clazz.getName());
    }
    
    public static boolean isList(Type type) {
        if (isParameterized(type)) {
            return isList(getOwnerType(type));
        }
        return isList((Class<?>) type);
    }
    
    public static boolean isList(Class<?> clazz) {
        return List.class.isAssignableFrom(clazz);
    }
    
    public static boolean isMap(Type type) {
        if (isParameterized(type)) {
            return isMap(getOwnerType(type));
        }
        return isMap((Class<?>) type);
    }
    
    public static boolean isMap(Class<?> clazz) {
        return Map.class.isAssignableFrom(clazz);
    }
    
    public static boolean isArray(Type type) {
        if (isParameterized(type)) {
            return false;
        }
        return isArray((Class<?>) type);
    }
    
    public static boolean isArray(Class<?> clazz) {
        return clazz.isArray();
    }
    
    public static boolean isSet(Type type) {
        if (isParameterized(type)) {
            return isSet(getOwnerType(type));
        }
        return isSet((Class<?>) type);
    }
    
    public static boolean isSet(Class<?> clazz) {
        return Set.class.isAssignableFrom(clazz);
    }
    
    public static boolean isCollection(Type type) {
        if (isParameterized(type)) {
            return isCollection(getOwnerType(type));
        }
        return isCollection((Class<?>) type);
    }
    
    public static boolean isCollection(Class<?> clazz) {
        return Collection.class.isAssignableFrom(clazz);
    }
    
    public static boolean isIterable(Type type) {
        if (isParameterized(type)) {
            return isIterable(getOwnerType(type));
        }
        return isIterable((Class<?>) type);
    }
    
    public static boolean isIterable(Class<?> clazz) {
        return Iterable.class.isAssignableFrom(clazz);
    }

    public static boolean hasNoArgsContrustor(Class<?> clazz) {
        return Stream.of(clazz.getConstructors())
                .allMatch(constructor -> constructor.getParameterCount() == 0);
    }
    
    public static Object getFieldValue(Field field, Object target) throws IllegalAccessException {
        return FieldUtils.readField(field, target, true);
    }
    
}
