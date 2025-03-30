package ru.kiscode.springcraftstarter;

import org.bukkit.plugin.java.JavaPlugin;
import ru.kiscode.springcraftstarter.di.SpringCraftApplication;
import ru.kiscode.springcraftstarter.di.annotation.ComponentScan;

@ComponentScan()
public final class SpringCraftStarter extends JavaPlugin {
    private static SpringCraftStarter instance;
    @Override
    public void onEnable() {
        instance = this;
        SpringCraftApplication.run(SpringCraftStarter.class);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static SpringCraftStarter getInstance() {
        return instance;
    }
}
