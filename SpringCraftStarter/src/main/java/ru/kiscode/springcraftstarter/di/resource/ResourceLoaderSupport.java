package ru.kiscode.springcraftstarter.di.resource;

import org.jetbrains.annotations.NotNull;


public interface ResourceLoaderSupport {
    void setResourceLoader(@NotNull ResourceLoader resourceLoader);
    ResourceLoader getResourceLoader();
}
