package ru.kiscode.springcraftstarter.di.registry;

import com.sun.istack.internal.NotNull;
import ru.kiscode.springcraftstarter.di.definition.BeanDefinition;
import ru.kiscode.springcraftstarter.di.exception.NotFindBeanException;

public interface BeanDefinitionRegistry {

    BeanDefinition getBeanDefinition(@NotNull String name, @NotNull Class<?> requiredType) throws NotFindBeanException;
    BeanDefinition getBeanDefinition(@NotNull Class<?> requiredType) throws NotFindBeanException;
    BeanDefinition getBeanDefinition(@NotNull String name) throws NotFindBeanException;

    void registerBeanDefinition(@NotNull BeanDefinition beanDefinition) throws NotFindBeanException;

    boolean containsBeanDefinition(@NotNull String name, @NotNull Class<?> requiredType) throws NotFindBeanException;
    boolean containsBeanDefinition(@NotNull String name) throws NotFindBeanException;
    boolean containsBeanDefinition(@NotNull Class<?> requiredType) throws NotFindBeanException;
    boolean containsBeanDefinition(@NotNull BeanDefinition beanDefinition) throws NotFindBeanException;

    void removeBeanDefinition(@NotNull String name, @NotNull Class<?> requiredType) throws NotFindBeanException;
    void removeBeanDefinition(@NotNull Class<?> requiredType) throws NotFindBeanException;
    void removeBeanDefinition(@NotNull String name) throws NotFindBeanException;
    void removeBeanDefinition(@NotNull BeanDefinition beanDefinition) throws NotFindBeanException;

}
