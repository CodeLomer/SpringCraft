package ru.kiscode.springcraftstarter.di.metadata;


public interface ClassMetadata {
    String getClassName();
    boolean isAssignableFrom(Class<?> assignableClass);
}
