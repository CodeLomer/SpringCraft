package ru.kiscode.springcraftstarter.di.filter.impl;

import ru.kiscode.springcraftstarter.di.filter.TypeFilter;
import ru.kiscode.springcraftstarter.di.metadata.ResourceMetadata;
import ru.kiscode.springcraftstarter.di.resource.ResourceLoader;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collection;

public class AnnotationFilterType implements TypeFilter {


    private final Collection<Class<? extends Annotation>> annotations;

    public AnnotationFilterType(Collection<Class<? extends Annotation>> annotations){
        this.annotations = annotations;
    }

    public AnnotationFilterType(Class<? extends Annotation> annotation){
        annotations = new ArrayList<>();
        annotations.add(annotation);
    }

    @Override
    public boolean matches(ResourceMetadata resourceMetadata, ResourceLoader resourceLoader) {
        return annotations.stream().anyMatch(annotation -> resourceMetadata.getAnnotationMetadata().hasAnnotation(annotation));
    }
}
