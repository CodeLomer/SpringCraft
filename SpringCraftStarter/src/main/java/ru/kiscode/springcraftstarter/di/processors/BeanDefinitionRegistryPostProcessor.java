package ru.kiscode.springcraftstarter.di.processors;

import org.jetbrains.annotations.NotNull;
import ru.kiscode.springcraftstarter.di.registry.BeanDefinitionRegistry;

public interface BeanDefinitionRegistryPostProcessor {
    void postProcessBeanDefinitionRegistry(@NotNull BeanDefinitionRegistry registry);
}
