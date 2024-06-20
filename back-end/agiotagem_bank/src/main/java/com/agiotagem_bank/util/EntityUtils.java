package com.agiotagem_bank.util;

import java.lang.reflect.Field;

public class EntityUtils {

    public static <T> T mergeEntities(T originalEntity, T newEntity) throws IllegalAccessException {
        Class<?> entityClass = originalEntity.getClass();
        Field[] fields = entityClass.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            Object newValue = field.get(newEntity);
            if (newValue != null) {
                field.set(originalEntity, newValue);
            }
        }

        return originalEntity;
    }
}
