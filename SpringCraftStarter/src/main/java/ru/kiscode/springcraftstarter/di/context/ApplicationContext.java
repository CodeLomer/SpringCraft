package ru.kiscode.springcraftstarter.di.context;

import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import ru.kiscode.springcraftstarter.di.registry.BeanRegistry;

public abstract class ApplicationContext {

    @NotNull
    protected final JavaPlugin plugin;
    @NotNull
    protected final BeanRegistry beanRegistry;

    public ApplicationContext(@NotNull JavaPlugin plugin, @NotNull BeanRegistry globalBeanRegistry) {
        this.plugin = plugin;
        this.beanRegistry = globalBeanRegistry;
    }
    public abstract void refresh();
    public abstract void setup();
    public abstract void run();
}
