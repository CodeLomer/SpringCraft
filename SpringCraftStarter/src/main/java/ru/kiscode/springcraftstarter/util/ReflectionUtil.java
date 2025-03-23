package ru.kiscode.springcraftstarter.util;

import io.github.classgraph.ClassGraph;
import io.github.classgraph.ScanResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.util.List;

public class ReflectionUtil {
    private final ScanResult scanResult;

    public ReflectionUtil(@NotNull String path, @Nullable ClassLoader classLoader){
        ClassGraph classGraph = new ClassGraph().enableClassInfo()
                .enableAnnotationInfo()
                .enableClassInfo()
                .acceptPackages(path);

        if(classLoader != null){
            classGraph.addClassLoader(classLoader);
        }
        scanResult = classGraph.scan();
    }

    public List<Class<?>> getAllClasses() {
        return scanResult.getAllClasses().loadClasses();
    }

    public boolean hasAnnotation(@NotNull Class<?> clazz, @NotNull Class<? extends Annotation> annotation) {
        if (clazz.isAnnotationPresent(annotation)) {
            return true;
        }

        for (Annotation a : clazz.getAnnotations()) {
            if (isValidAnnotation(a)) {
                if (a.annotationType().isAnnotationPresent(annotation)) {
                    return true;
                }
                if (hasAnnotation(a.annotationType(), annotation)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isValidAnnotation(@NotNull Annotation annotation) {
        return !annotation.annotationType().isAnnotationPresent(Documented.class);
    }

}
