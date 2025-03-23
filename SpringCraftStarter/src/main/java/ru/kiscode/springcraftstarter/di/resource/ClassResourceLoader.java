package ru.kiscode.springcraftstarter.di.resource;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.kiscode.springcraftstarter.util.ReflectionUtil;

import java.util.List;
import java.util.Objects;

public class ClassResourceLoader implements ResourceLoader<List<Class<?>>>{
    private @NotNull
    final String path;
    private @Nullable
    final ClassLoader classLoader;

    public ClassResourceLoader(@NotNull String path, @Nullable ClassLoader classLoader){
        this.classLoader = classLoader;
        Objects.requireNonNull(path,"class path not can be null");
        this.path = path;
    }
    @Override
    public List<Class<?>> loadResource() {
        return new ReflectionUtil(path,classLoader).getAllClasses();
    }
}
