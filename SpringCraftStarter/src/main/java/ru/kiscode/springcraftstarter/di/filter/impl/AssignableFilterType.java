package ru.kiscode.springcraftstarter.di.filter.impl;

import ru.kiscode.springcraftstarter.di.filter.TypeFilter;



import ru.kiscode.springcraftstarter.di.metadata.ResourceMetadata;
import ru.kiscode.springcraftstarter.di.resource.ResourceLoader;

import java.util.Collection;

public class AssignableFilterType implements TypeFilter {
    private final Collection<Class<?>> assignableClass;

    public AssignableFilterType(Collection<Class<?>> assignableClass) {
        this.assignableClass = assignableClass;
    }


    @Override
    public boolean matches(ResourceMetadata resourceMetadata, ResourceLoader resourceLoader) {
        return assignableClass.stream().anyMatch(aClass -> resourceMetadata.getClassMetadata().isAssignableFrom(aClass));
    }
}
