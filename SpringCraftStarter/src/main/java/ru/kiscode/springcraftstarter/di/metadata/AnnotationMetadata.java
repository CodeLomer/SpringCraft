package ru.kiscode.springcraftstarter.di.metadata;

import ru.kiscode.springcraftstarter.di.annotation.ComponentScan;

import java.lang.annotation.Annotation;

public interface AnnotationMetadata {
    boolean hasAnnotation(Class<? extends Annotation> annotation);

    <T extends Annotation> T getAnnotation(Class<T> annotation);
}
