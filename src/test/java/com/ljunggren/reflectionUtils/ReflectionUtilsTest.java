package com.ljunggren.reflectionUtils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class ReflectionUtilsTest {
    
    Number number;
    Double objectDouble;
    double primitiveDouble;
    List<String> stringList;
    Set<Integer> integerSet;
    Collection<Boolean> booleanCollection;
    Map<Integer, String> integerStringMap;
    HashMap<Integer, String> integerStringHashMap;
    String[] stringArray;
    boolean primitiveBoolean;
    Boolean objectBoolean;
    String string;
    Set<Integer> intergerSet;
    int primitiveInteger;
    Integer objectInteger;
    Iterable<String> stringIterable;
    BigDecimal bigDecimal;
    
    @Test
    public void constructorTest() {
        ReflectionUtils reflectionUtils = new ReflectionUtils();
        assertTrue(reflectionUtils instanceof ReflectionUtils);
    }
    
    @Test
    public void getObjectFieldsTest() {
        List<Field> fields = ReflectionUtils.getObjectFields(this.getClass());
        boolean hasStringList = fields.stream().anyMatch(field -> field.getName().equals("stringList"));
        assertTrue(hasStringList);
    }

    @Test
    public void getOwnerTypeNullTest() {
        Type type = ReflectionUtils.getOwnerType(null);
        assertEquals(null, type);
    }

    @Test
    public void getOwnerTypeStringTest() {
        Type type = ReflectionUtils.getOwnerType(String.class);
        assertEquals(null, type);
    }

    @Test
    public void getOwnerTypeListTest() throws NoSuchFieldException, SecurityException {
        Field field = ReflectionUtilsTest.class.getDeclaredField("stringList");
        Type fieldType = field.getGenericType();
        Type type = ReflectionUtils.getOwnerType(fieldType);
        assertEquals(List.class, type);
    }

    @Test
    public void getOwnerTypeSetTest() throws NoSuchFieldException, SecurityException {
        Field field = ReflectionUtilsTest.class.getDeclaredField("integerSet");
        Type fieldType = field.getGenericType();
        Type type = ReflectionUtils.getOwnerType(fieldType);
        assertEquals(Set.class, type);
    }

    @Test
    public void getOwnerTypeBooleanTest() throws NoSuchFieldException, SecurityException {
        Field field = ReflectionUtilsTest.class.getDeclaredField("booleanCollection");
        Type fieldType = field.getGenericType();
        Type type = ReflectionUtils.getOwnerType(fieldType);
        assertEquals(Collection.class, type);
    }
    
    @Test
    public void getParameterizedTypesNullTest() {
        Type[] types = ReflectionUtils.getParameterizedTypes(null);
        assertEquals(0, types.length);
    }
    
    @Test
    public void getParameterizedTypesMapTest() throws NoSuchFieldException, SecurityException {
        Field field = ReflectionUtilsTest.class.getDeclaredField("integerStringMap");
        Type fieldType = field.getGenericType();
        Type[] types = ReflectionUtils.getParameterizedTypes(fieldType);
        assertEquals(2, types.length);
        assertEquals(Integer.class, types[0]);
        assertEquals(String.class, types[1]);
    }
    
    @Test
    public void getParameterizedTypeNullTest() {
        Type type = ReflectionUtils.getParameterizedType(null);
        assertNull(type);
    }
    
    @Test
    public void getParameterizedTypeNonParameterizedTest() {
        Type type = ReflectionUtils.getOwnerType(String.class);
        assertEquals(null, type);
    }

    @Test
    public void getParameterizedTypeStringTest() throws NoSuchFieldException, SecurityException {
        Field field = ReflectionUtilsTest.class.getDeclaredField("stringList");
        Type fieldType = field.getGenericType();
        Type type = ReflectionUtils.getParameterizedType(fieldType);
        assertEquals(String.class, type);
    }
    
    @Test
    public void getArrayComponentTypeTest() throws NoSuchFieldException, SecurityException {
        Field field = ReflectionUtilsTest.class.getDeclaredField("stringArray");
        Type fieldType = field.getGenericType();
        Type type = ReflectionUtils.getArrayComponentType(fieldType);
        assertEquals(String.class, type);
    }
    
    @Test
    public void getArrayComponentTypeFalseTest() throws NoSuchFieldException, SecurityException {
        Field field = ReflectionUtilsTest.class.getDeclaredField("string");
        Type fieldType = field.getGenericType();
        Type type = ReflectionUtils.getArrayComponentType(fieldType);
        assertEquals(null, type);
    }
    
    @Test
    public void isPrimitiveTest() throws NoSuchFieldException, SecurityException {
        Field field = ReflectionUtilsTest.class.getDeclaredField("primitiveBoolean");
        Type fieldType = field.getGenericType();
        assertTrue(ReflectionUtils.isPrimitive(fieldType));
    }
    
    @Test
    public void isNumberTest() throws NoSuchFieldException, SecurityException {
        Field field = ReflectionUtilsTest.class.getDeclaredField("number");
        Type fieldType = field.getGenericType();
        assertTrue(ReflectionUtils.isNumber(fieldType));
    }
    
    @Test
    public void isNumberIntegerTest() throws NoSuchFieldException, SecurityException {
        Field field = ReflectionUtilsTest.class.getDeclaredField("objectInteger");
        Type fieldType = field.getGenericType();
        assertTrue(ReflectionUtils.isNumber(fieldType));
    }
    
    @Test
    public void isNumberPrimitiveTest() throws NoSuchFieldException, SecurityException {
        Field field = ReflectionUtilsTest.class.getDeclaredField("primitiveInteger");
        Type fieldType = field.getGenericType();
        assertFalse(ReflectionUtils.isNumber(fieldType));
    }
    
    @Test
    public void isNumberParameterizedTest() throws NoSuchFieldException, SecurityException {
        Field field = ReflectionUtilsTest.class.getDeclaredField("integerSet");
        Type fieldType = field.getGenericType();
        assertFalse(ReflectionUtils.isNumber(fieldType));
    }
    
    @Test
    public void isIntegerPrimitiveTest() throws NoSuchFieldException, SecurityException {
        Field field = ReflectionUtilsTest.class.getDeclaredField("primitiveInteger");
        Type fieldType = field.getGenericType();
        assertFalse(ReflectionUtils.isInteger(fieldType));
    }
    
    @Test
    public void isIntegerObjectTest() throws NoSuchFieldException, SecurityException {
        Field field = ReflectionUtilsTest.class.getDeclaredField("objectInteger");
        Type fieldType = field.getGenericType();
        assertTrue(ReflectionUtils.isInteger(fieldType));
    }
    
    @Test
    public void isIntegerParameterizedTest() throws NoSuchFieldException, SecurityException {
        Field field = ReflectionUtilsTest.class.getDeclaredField("stringList");
        Type fieldType = field.getGenericType();
        assertFalse(ReflectionUtils.isInteger(fieldType));
    }
    
    @Test
    public void isIntegerFalseTest() throws NoSuchFieldException, SecurityException {
        Field field = ReflectionUtilsTest.class.getDeclaredField("string");
        Type fieldType = field.getGenericType();
        assertFalse(ReflectionUtils.isInteger(fieldType));
    }
    
    @Test
    public void isDoublePrimitiveTest() throws NoSuchFieldException, SecurityException {
        Field field = ReflectionUtilsTest.class.getDeclaredField("primitiveDouble");
        Type fieldType = field.getGenericType();
        assertFalse(ReflectionUtils.isDouble(fieldType));
    }
    
    @Test
    public void isDoubleObjectTest() throws NoSuchFieldException, SecurityException {
        Field field = ReflectionUtilsTest.class.getDeclaredField("objectDouble");
        Type fieldType = field.getGenericType();
        assertTrue(ReflectionUtils.isDouble(fieldType));
    }
    
    @Test
    public void isDoubleParameterizedTest() throws NoSuchFieldException, SecurityException {
        Field field = ReflectionUtilsTest.class.getDeclaredField("stringList");
        Type fieldType = field.getGenericType();
        assertFalse(ReflectionUtils.isDouble(fieldType));
    }
    
    @Test
    public void isDoubleFalseTest() throws NoSuchFieldException, SecurityException {
        Field field = ReflectionUtilsTest.class.getDeclaredField("string");
        Type fieldType = field.getGenericType();
        assertFalse(ReflectionUtils.isDouble(fieldType));
    }
    
    @Test
    public void isBigDecimalTest() throws NoSuchFieldException, SecurityException {
        Field field = ReflectionUtilsTest.class.getDeclaredField("bigDecimal");
        Type fieldType = field.getGenericType();
        assertTrue(ReflectionUtils.isBigDecimal(fieldType));
    }
    
    @Test
    public void isBigDecimalFalseTest() throws NoSuchFieldException, SecurityException {
        Field field = ReflectionUtilsTest.class.getDeclaredField("string");
        Type fieldType = field.getGenericType();
        assertFalse(ReflectionUtils.isBigDecimal(fieldType));
    }
    
    @Test
    public void isBigDecimalParameterizedTest() throws NoSuchFieldException, SecurityException {
        Field field = ReflectionUtilsTest.class.getDeclaredField("stringList");
        Type fieldType = field.getGenericType();
        assertFalse(ReflectionUtils.isBigDecimal(fieldType));
    }
    
    @Test
    public void isPrimitiveFalseTest() throws NoSuchFieldException, SecurityException {
        Field field = ReflectionUtilsTest.class.getDeclaredField("stringList");
        Type fieldType = field.getGenericType();
        assertFalse(ReflectionUtils.isPrimitive(fieldType));
    }
    
    @Test
    public void isParameterizedTest() throws NoSuchFieldException, SecurityException {
        Field field = ReflectionUtilsTest.class.getDeclaredField("stringList");
        Type fieldType = field.getGenericType();
        assertTrue(ReflectionUtils.isParameterized(fieldType));
    }
    
    @Test
    public void isParameterizedFalseTest() throws NoSuchFieldException, SecurityException {
        Field field = ReflectionUtilsTest.class.getDeclaredField("primitiveBoolean");
        Type fieldType = field.getGenericType();
        assertFalse(ReflectionUtils.isParameterized(fieldType));
    }
    
    @Test
    public void isListTest() throws NoSuchFieldException, SecurityException {
        Field field = ReflectionUtilsTest.class.getDeclaredField("stringList");
        Type fieldType = field.getGenericType();
        assertTrue(ReflectionUtils.isList(fieldType));
    }
    
    @Test
    public void isListFalseTest() throws NoSuchFieldException, SecurityException {
        Field field = ReflectionUtilsTest.class.getDeclaredField("string");
        Type fieldType = field.getGenericType();
        assertFalse(ReflectionUtils.isList(fieldType));
    }
    
    @Test
    public void isListParamaterizedFalseTest() throws NoSuchFieldException, SecurityException {
        Field field = ReflectionUtilsTest.class.getDeclaredField("integerSet");
        Type fieldType = field.getGenericType();
        assertFalse(ReflectionUtils.isList(fieldType));
    }
    
    @Test
    public void isMapTest() throws NoSuchFieldException, SecurityException {
        Field field = ReflectionUtilsTest.class.getDeclaredField("integerStringMap");
        Type fieldType = field.getGenericType();
        assertTrue(ReflectionUtils.isMap(fieldType));
    }
    
    @Test
    public void isMapFalseTest() throws NoSuchFieldException, SecurityException {
        Field field = ReflectionUtilsTest.class.getDeclaredField("string");
        Type fieldType = field.getGenericType();
        assertFalse(ReflectionUtils.isMap(fieldType));
    }
    
    @Test
    public void isHashMapTest() throws NoSuchFieldException, SecurityException {
        Field field = ReflectionUtilsTest.class.getDeclaredField("integerStringHashMap");
        Type fieldType = field.getGenericType();
        assertTrue(ReflectionUtils.isMap(fieldType));
    }
    
    @Test
    public void isHshMapFalseTest() throws NoSuchFieldException, SecurityException {
        Field field = ReflectionUtilsTest.class.getDeclaredField("string");
        Type fieldType = field.getGenericType();
        assertFalse(ReflectionUtils.isMap(fieldType));
    }
    
    @Test
    public void isArrayTest() throws NoSuchFieldException, SecurityException {
        Field field = ReflectionUtilsTest.class.getDeclaredField("stringArray");
        Type fieldType = field.getGenericType();
        assertTrue(ReflectionUtils.isArray(fieldType));
    }
    
    @Test
    public void isArrayFalseTest() throws NoSuchFieldException, SecurityException {
        Field field = ReflectionUtilsTest.class.getDeclaredField("stringList");
        Type fieldType = field.getGenericType();
        assertFalse(ReflectionUtils.isArray(fieldType));
    }
    
    @Test
    public void isStringTest() throws NoSuchFieldException, SecurityException {
        Field field = ReflectionUtilsTest.class.getDeclaredField("string");
        Type fieldType = field.getGenericType();
        assertTrue(ReflectionUtils.isString(fieldType));
    }
    
    @Test
    public void isStringFalseTest() throws NoSuchFieldException, SecurityException {
        Field field = ReflectionUtilsTest.class.getDeclaredField("objectBoolean");
        Type fieldType = field.getGenericType();
        assertFalse(ReflectionUtils.isString(fieldType));
    }
    
    @Test
    public void isStringParameterizedTest() throws NoSuchFieldException, SecurityException {
        Field field = ReflectionUtilsTest.class.getDeclaredField("stringList");
        Type fieldType = field.getGenericType();
        assertFalse(ReflectionUtils.isString(fieldType));
    }
    
    @Test
    public void isSetTest() throws NoSuchFieldException, SecurityException {
        Field field = ReflectionUtilsTest.class.getDeclaredField("integerSet");
        Type fieldType = field.getGenericType();
        assertTrue(ReflectionUtils.isSet(fieldType));
    }
    
    @Test
    public void isSetParameterizedFalseTest() throws NoSuchFieldException, SecurityException {
        Field field = ReflectionUtilsTest.class.getDeclaredField("stringList");
        Type fieldType = field.getGenericType();
        assertFalse(ReflectionUtils.isSet(fieldType));
    }
    
    @Test
    public void isSetFalseTest() throws NoSuchFieldException, SecurityException {
        Field field = ReflectionUtilsTest.class.getDeclaredField("string");
        Type fieldType = field.getGenericType();
        assertFalse(ReflectionUtils.isSet(fieldType));
    }
    
    @Test
    public void isCollectionTest() throws NoSuchFieldException, SecurityException {
        Field field = ReflectionUtilsTest.class.getDeclaredField("stringList");
        Type fieldType = field.getGenericType();
        assertTrue(ReflectionUtils.isCollection(fieldType));
    }
    
    @Test
    public void isCollectionFalseTest() throws NoSuchFieldException, SecurityException {
        Field field = ReflectionUtilsTest.class.getDeclaredField("string");
        Type fieldType = field.getGenericType();
        assertFalse(ReflectionUtils.isCollection(fieldType));
    }
    
    @Test
    public void isIterableTest() throws NoSuchFieldException, SecurityException {
        Field field = ReflectionUtilsTest.class.getDeclaredField("stringIterable");
        Type fieldType = field.getGenericType();
        assertTrue(ReflectionUtils.isIterable(fieldType));
    }
    
    @Test
    public void isIterableFalseTest() throws NoSuchFieldException, SecurityException {
        Field field = ReflectionUtilsTest.class.getDeclaredField("string");
        Type fieldType = field.getGenericType();
        assertFalse(ReflectionUtils.isIterable(fieldType));
    }
    
    @Test
    public void hasNoArgsConstructorFalseTest() throws NoSuchFieldException, SecurityException {
        Field field = ReflectionUtilsTest.class.getDeclaredField("string");
        Type fieldType = field.getGenericType();
        assertFalse(ReflectionUtils.hasNoArgsContrustor((Class<?>) fieldType));
    }
    
    @Test
    public void getFieldValueTest() throws NoSuchFieldException, SecurityException, IllegalAccessException {
        string = "test";
        Field field = ReflectionUtilsTest.class.getDeclaredField("string");
        String value = (String) ReflectionUtils.getFieldValue(field, this);
        assertEquals("test", value);
    }
    
}
