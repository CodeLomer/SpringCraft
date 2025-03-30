package ru.kiscode.springcraftstarter.di.filter;



import ru.kiscode.springcraftstarter.di.metadata.ResourceMetadata;
import ru.kiscode.springcraftstarter.di.resource.ResourceLoader;

public interface TypeFilter {
    boolean matches(ResourceMetadata classMetadata, ResourceLoader resourceLoader);
}
