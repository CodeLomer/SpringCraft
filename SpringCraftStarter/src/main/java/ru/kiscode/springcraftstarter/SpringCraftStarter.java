package ru.kiscode.springcraftstarter;

import org.bukkit.plugin.java.JavaPlugin;
import ru.kiscode.springcraftstarter.di.SpringCraftApplication;
import ru.kiscode.springcraftstarter.di.registry.BeanRegistry;

public final class SpringCraftStarter extends JavaPlugin {
    private static SpringCraftStarter instance;
    private BeanRegistry globalRegistry;
    @Override
    public void onEnable() {
        instance = this;
        SpringCraftApplication.run(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static SpringCraftStarter getInstance() {
        return instance;
    }

    public BeanRegistry getGlobalRegistry() {
        return globalRegistry;
    }
}
