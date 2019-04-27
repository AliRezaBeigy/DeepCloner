package com.github.alirezabeigy;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

class DeepCloner {

    void clone(DeepCloner copy) {
        if (copy == null) {
            try {
                Constructor<? extends DeepCloner> constructor = getClass().getDeclaredConstructor();
                constructor.setAccessible(true);
                copy = constructor.newInstance();
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException ignored) {
            }
        }
        for (Field field : this.getClass().getDeclaredFields())
            if (field.getType().getSuperclass().equals(DeepCloner.class)) {
                try {
                    field.setAccessible(true);
                    Object cloner = null;
                    try {
                        Constructor<?> constructor = field.getType().getDeclaredConstructor();
                        constructor.setAccessible(true);
                        cloner = constructor.newInstance();
                    } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException ignored) {
                    }
                    ((DeepCloner) field.get(this)).clone((DeepCloner) cloner);
                    setValue(copy, field, cloner);
                } catch (IllegalAccessException ignored) {
                }
            } else {
                try {
                    field.setAccessible(true);
                    setValue(copy, field, field.get(this));
                } catch (IllegalAccessException ignored) {
                }
            }
    }

    private void setValue(DeepCloner copy, Field field, Object object) {
        try {
            field.setAccessible(true);
            field.set(copy, object);
        } catch (IllegalAccessException ignored) {
        }
    }
}
