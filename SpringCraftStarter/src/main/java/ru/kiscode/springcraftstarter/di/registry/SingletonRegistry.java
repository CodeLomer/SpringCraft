package ru.kiscode.springcraftstarter.di.registry;

import com.sun.istack.internal.NotNull;
import ru.kiscode.springcraftstarter.di.exception.NotFindBeanException;

public interface SingletonRegistry {

    <T> T getSingleton(@NotNull String name, @NotNull Class<T> requiredType) throws NotFindBeanException;
    <T> T getSingleton(@NotNull Class<T> requiredType) throws NotFindBeanException;
    Object getSingleton(@NotNull String name) throws NotFindBeanException;

    void registerSingleton(@NotNull String name, @NotNull Class<?> requiredType, @NotNull Object bean) throws NotFindBeanException;
    void registerSingleton(@NotNull Class<?> requiredType, @NotNull Object bean) throws NotFindBeanException;
    void registerSingleton(@NotNull String name, @NotNull Object bean) throws NotFindBeanException;

    boolean containSingleton(@NotNull String name, @NotNull Class<?> requiredType) throws NotFindBeanException;
    boolean containSingleton(@NotNull Class<?> requiredType) throws NotFindBeanException;
    boolean containSingleton(@NotNull String name) throws NotFindBeanException;

    void removeSingleton(@NotNull String name, @NotNull Class<?> requiredType) throws NotFindBeanException;
    void removeSingleton(@NotNull Class<?> requiredType) throws NotFindBeanException;
    void removeSingleton(@NotNull String name) throws NotFindBeanException;

}
