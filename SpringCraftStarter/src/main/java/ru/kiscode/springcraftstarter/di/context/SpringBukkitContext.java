package ru.kiscode.springcraftstarter.di.context;

import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import ru.kiscode.springcraftstarter.di.registry.BeanRegistry;

public class SpringBukkitContext extends ApplicationContext{


    public SpringBukkitContext(@NotNull JavaPlugin plugin, @NotNull BeanRegistry globalRegistry) {
        super(plugin, globalRegistry);
    }

    @Override
    public void refresh() {

    }

    @Override
    public void setup() {

    }

    @Override
    public void run() {

    }
}
