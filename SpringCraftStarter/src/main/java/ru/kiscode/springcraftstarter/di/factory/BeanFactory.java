package ru.kiscode.springcraftstarter.di.factory;


import com.sun.istack.internal.NotNull;
import ru.kiscode.springcraftstarter.di.definition.BeanDefinition;
import ru.kiscode.springcraftstarter.di.exception.NotFindBeanException;

public interface BeanFactory {
    <T> T getBean(@NotNull String name, @NotNull Class<T> requiredType, Object... args) throws NotFindBeanException;
    <T> T getBean(@NotNull Class<T> requiredType, Object... args) throws NotFindBeanException;
    Object getBean(@NotNull String name, Object... args) throws NotFindBeanException;

    <T> T getBean(@NotNull BeanDefinition beanDefinition, @NotNull Class<T> requiredType, Object... args) throws NotFindBeanException;
    Object getBean(@NotNull BeanDefinition beanDefinition, Object... args) throws NotFindBeanException;

    boolean containBean(@NotNull String name, @NotNull Class<?> requiredType) throws NotFindBeanException;
    boolean containBean(@NotNull BeanDefinition beanDefinition) throws NotFindBeanException;
    boolean containBean(@NotNull Class<?> requiredType) throws NotFindBeanException;
    boolean containBean(@NotNull String name) throws NotFindBeanException;

    boolean isSingleton(@NotNull String name, @NotNull Class<?> requiredType) throws NotFindBeanException;
    boolean isSingleton(@NotNull Class<?> requiredType) throws NotFindBeanException;
    boolean isSingleton(@NotNull String name) throws NotFindBeanException;

    boolean isPrototype(@NotNull String name, @NotNull Class<?> requiredType) throws NotFindBeanException;
    boolean isPrototype(@NotNull Class<?> requiredType) throws NotFindBeanException;
    boolean isPrototype(@NotNull String name) throws NotFindBeanException;
}
