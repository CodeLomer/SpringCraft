package ru.kiscode.springcraftstarter.di.resource;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.kiscode.springcraftstarter.di.metadata.ResourceMetadata;

import java.util.Collection;

public interface ResourceLoader {
    @Nullable ClassLoader getClassLoader();
    @Nullable ResourceMetadata getResourceMetadata(@NotNull String className);
    @NotNull Collection<ResourceMetadata> getResourceMetadataList(@NotNull String basePackage);
    @NotNull Collection<ResourceMetadata> getResourceMetadataList(String... basePackages);
}
