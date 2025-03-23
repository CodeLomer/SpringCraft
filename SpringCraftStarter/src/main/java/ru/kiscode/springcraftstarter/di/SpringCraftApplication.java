package ru.kiscode.springcraftstarter.di;

import org.bukkit.plugin.java.JavaPlugin;
import ru.kiscode.springcraftstarter.SpringCraftStarter;
import ru.kiscode.springcraftstarter.di.context.ApplicationContext;
import ru.kiscode.springcraftstarter.di.context.SpringBukkitContext;

public class SpringCraftApplication {
    private static ApplicationContext context;
    public static void run(JavaPlugin plugin) {
        if(context == null) context = new SpringBukkitContext(plugin, SpringCraftStarter.getInstance().getGlobalRegistry());
        context.refresh();
        context.setup();
    }


    public static void stop() {
        if(context != null){
            context.run();
        }
    }
}
