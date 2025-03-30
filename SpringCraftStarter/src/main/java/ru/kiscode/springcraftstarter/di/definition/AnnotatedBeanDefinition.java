package ru.kiscode.springcraftstarter.di.definition;

import org.jetbrains.annotations.NotNull;
import ru.kiscode.springcraftstarter.di.metadata.ResourceMetadata;

public class AnnotatedBeanDefinition implements BeanDefinition {

    @NotNull
    private final ResourceMetadata resourceMetadata;

    public AnnotatedBeanDefinition(@NotNull ResourceMetadata resourceMetadata){
        this.resourceMetadata = resourceMetadata;
    }
}
