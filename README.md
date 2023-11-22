## Reflection Utils

A collection of useful reflection utilities.

Get Owner Type

```java
Type owner = ReflectionUtils.getOwnerType(type);
```

Is Parameterized

```java
boolean isParameterized = ReflectionUtils.isParameterized(type);
```

Get Parameterized Type

```java
Type parameterizedType = ReflectionUtils.getParameterizedTypes(type);
```

Get Parameterized Types

```java
Type[] parameterizedTypes = ReflectionUtils.getParameterizedTypes(type);
```

Get Array Component Type

```java
Type componentType = ReflectionUtils.getArrayComponentType(type);
```

Get Object Fields

```java
List<Field> fields = ReflectionUtils.getObjectFields(clazz);
```

Is Primitive

```java
boolean isPrimitive = ReflectionUtils.isPrimitive(type);
boolean isPrimitive = ReflectionUtils.isPrimitive(clazz);
```

Is Number

```java
boolean isNumber = ReflectionUtils.isNumber(t);
boolean isNumber = ReflectionUtils.isNumber(type);
boolean isNumber = ReflectionUtils.isNumber(clazz);
```

Is Integer

```java
boolean isInteger = ReflectionUtils.isInteger(t);
boolean isInteger = ReflectionUtils.isInteger(type);
boolean isInteger = ReflectionUtils.isInteger(clazz);
```

Is Double

```java
boolean isDouble = ReflectionUtils.isDouble(t);
boolean isDouble = ReflectionUtils.isDouble(type);
boolean isDouble = ReflectionUtils.isDouble(clazz);
```

Is Short

```java
boolean isShort = ReflectionUtils.isShort(t);
boolean isShort = ReflectionUtils.isShort(type);
boolean isShort = ReflectionUtils.isShort(clazz);
```

Is Long

```java
boolean isLong = ReflectionUtils.isLong(t);
boolean isLong = ReflectionUtils.isLong(type);
boolean isLong = ReflectionUtils.isLong(clazz);
```

Is Float

```java
boolean isFloat = ReflectionUtils.isFloat(t);
boolean isFloat = ReflectionUtils.isFloat(type);
boolean isFloat = ReflectionUtils.isFloat(clazz);
```

Is Big Decimal

```java
boolean isBigDecimal = ReflectionUtils.isBigDecimal(t);
boolean isBigDecimal = ReflectionUtils.isBigDecimal(type);
boolean isBigDecimal = ReflectionUtils.isBigDecimal(clazz);
```

Is Byte

```java
boolean isByte = ReflectionUtils.isByte(t);
boolean isByte = ReflectionUtils.isByte(type);
boolean isByte = ReflectionUtils.isByte(clazz);
```

Is Boolean

```java
boolean isBoolean = ReflectionUtils.isBoolean(t);
boolean isBoolean = ReflectionUtils.isBoolean(type);
boolean isBoolean = ReflectionUtils.isBoolean(clazz);
```

Is String

```java
boolean isString = ReflectionUtils.isString(t);
boolean isString = ReflectionUtils.isString(type);
boolean isString = ReflectionUtils.isString(clazz);
```

Is List

```java
boolean isList = ReflectionUtils.isList(t);
boolean isList = ReflectionUtils.isList(type);
boolean isList = ReflectionUtils.isList(clazz);
```

Is Map

```java
boolean isMap = ReflectionUtils.isMap(t);
boolean isMap = ReflectionUtils.isMap(type);
boolean isMap = ReflectionUtils.isMap(clazz);
```

Is Array

```java
boolean isArray = ReflectionUtils.isArray(t);
boolean isArray = ReflectionUtils.isArray(type);
boolean isArray = ReflectionUtils.isArray(clazz);
```

Is Set

```java
boolean isSet = ReflectionUtils.isSet(t);
boolean isSet = ReflectionUtils.isSet(type);
boolean isSet = ReflectionUtils.isSet(clazz);
```

Is Collection

```java
boolean isCollection = ReflectionUtils.isCollection(t);
boolean isCollection = ReflectionUtils.isCollection(type);
boolean isCollection = ReflectionUtils.isCollection(clazz);
```

Is Iterable

```java
boolean isIterable = ReflectionUtils.isIterable(t);
boolean isIterable = ReflectionUtils.isIterable(type);
boolean isIterable = ReflectionUtils.isIterable(clazz);
```

Has no Arguments Constructor

```java
boolean hasNoArgsContrustor = ReflectionUtils.hasNoArgsContrustor(type);
boolean hasNoArgsContrustor = ReflectionUtils.hasNoArgsContrustor(clazz);
```

Get Field Value

```java
Object value = ReflectionUtils.getFieldValue(field, object);
```

Classes isEqual

```java
boolean isEqual = ReflectionUtils.isEqual(clazz1, clazz2);
```
