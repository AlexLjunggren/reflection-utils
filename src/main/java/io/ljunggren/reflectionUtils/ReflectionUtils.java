package io.ljunggren.reflectionUtils;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigDecimal;
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
        if (type == null) {
            return false;
        }
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
        return isParameterized(type) ? false : isPrimitive((Class<?>) type);
    }
    
    public static boolean isPrimitive(Class<?> clazz) {
        return clazz.isPrimitive();
    }
    
    public static <T> boolean isNumber(T t) {
        return t instanceof Number;
    }
    
    public static boolean isNumber(Type type) {
        return isParameterized(type) ? false : isNumber((Class<?>) type);
     }
    
    public static boolean isNumber(Class<?> clazz) {
        return clazz == null ? false : Number.class.isAssignableFrom(clazz);
    }
    
    public static <T> boolean isInteger(T t) {
        return t instanceof Integer;
    }
    
    public static boolean isInteger(Type type) {
        return isParameterized(type) ? false : isInteger((Class<?>) type);
    }
    
    public static boolean isInteger(Class<?> clazz) {
        return isEqual(clazz, Integer.class);
    }
    
    public static <T> boolean isDouble(T t) {
        return t instanceof Double;
    }
    
    public static boolean isDouble(Type type) {
        return isParameterized(type) ? false : isDouble((Class<?>) type);
    }
    
    public static boolean isDouble(Class<?> clazz) {
        return isEqual(clazz, Double.class);
    }
    
    public static <T> boolean isShort(T t) {
        return t instanceof Short;
    }
    
    public static boolean isShort(Type type) {
        return isParameterized(type) ? false : isShort((Class<?>) type);
    }
    
    public static boolean isShort(Class<?> clazz) {
        return isEqual(clazz, Short.class);
    }
    
    public static <T> boolean isLong(T t) {
        return t instanceof Long;
    }
    
    public static boolean isLong(Type type) {
        return isParameterized(type) ? false : isLong((Class<?>) type);
    }
    
    public static boolean isLong(Class<?> clazz) {
        return isEqual(clazz, Long.class);
    }
    
    public static <T> boolean isFloat(T t) {
        return t instanceof Float;
    }
    
    public static boolean isFloat(Type type) {
        return isParameterized(type) ? false : isFloat((Class<?>) type);
    }
    
    public static boolean isFloat(Class<?> clazz) {
        return isEqual(clazz, Float.class);
    }
    
    public static <T> boolean isBigDecimal(T t) {
        return t instanceof BigDecimal;
    }
    
    public static boolean isBigDecimal(Type type) {
        return isParameterized(type) ? false : isBigDecimal((Class<?>) type);
    }
    
    public static boolean isBigDecimal(Class<?> clazz) {
        return isEqual(clazz, BigDecimal.class);
    }
    
    public static <T> boolean isByte(T t) {
        return t instanceof Byte;
    }
    
    public static boolean isByte(Type type) {
        return isParameterized(type) ? false : isByte((Class<?>) type);
    }
    
    public static boolean isByte(Class<?> clazz) {
        return isEqual(clazz, Byte.class);
    }
    
    public static <T> boolean isBoolean(T t) {
        return t instanceof Boolean;
    }
    
    public static boolean isBoolean(Type type) {
        return isParameterized(type) ? false : isBoolean((Class<?>) type);
    }
    
    public static boolean isBoolean(Class<?> clazz) {
        return isEqual(clazz, Boolean.class);
    }
    
    public static <T> boolean isString(T t) {
        return t instanceof String;
    }
    
    public static boolean isString(Type type) {
        return isParameterized(type) ? false : isString((Class<?>) type);
    }
    
    public static boolean isString(Class<?> clazz) {
        return isEqual(clazz, String.class);
    }
    
    public static <T> boolean isList(T t) {
        return t instanceof List;
    }
    
    public static boolean isList(Type type) {
        return isParameterized(type) ? isList(getOwnerType(type)) : isList((Class<?>) type);
    }
    
    public static boolean isList(Class<?> clazz) {
        return clazz == null ? false : List.class.isAssignableFrom(clazz);
    }
    
    public static <T> boolean isMap(T t) {
        return t instanceof Map;
    }
    
    public static boolean isMap(Type type) {
        return isParameterized(type) ? isMap(getOwnerType(type)) : isMap((Class<?>) type);
    }
    
    public static boolean isMap(Class<?> clazz) {
        return clazz == null ? false : Map.class.isAssignableFrom(clazz);
    }
    
    public static boolean isArray(Type type) {
        return isParameterized(type) ? false : isArray((Class<?>) type);
    }
    
    public static boolean isArray(Class<?> clazz) {
        return clazz.isArray();
    }
    
    public static boolean isSet(Type type) {
        return isParameterized(type) ? isSet(getOwnerType(type)) : isSet((Class<?>) type);
    }
    
    public static boolean isSet(Class<?> clazz) {
        return Set.class.isAssignableFrom(clazz);
    }
    
    public static boolean isCollection(Type type) {
        return isParameterized(type) ? isCollection(getOwnerType(type)) : isCollection((Class<?>) type);
    }
    
    public static boolean isCollection(Class<?> clazz) {
        return Collection.class.isAssignableFrom(clazz);
    }
    
    public static boolean isIterable(Type type) {
        return isParameterized(type) ? isIterable(getOwnerType(type)) : isIterable((Class<?>) type);
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
    
    private static boolean isEqual(Class<?> class1, Class<?> class2) {
        if (class1 == null && class2 == null) {
            return true;
        }
        if (class1 == null || class2 == null) {
            return false;
        }
        return class1.getName().equals(class2.getName());
    }
    
}
