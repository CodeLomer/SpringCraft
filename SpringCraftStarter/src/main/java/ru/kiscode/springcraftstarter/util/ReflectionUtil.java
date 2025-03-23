package ru.kiscode.springcraftstarter.util;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;
import io.github.classgraph.ClassGraph;
import io.github.classgraph.ScanResult;
import org.bukkit.plugin.java.JavaPlugin;

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


}
