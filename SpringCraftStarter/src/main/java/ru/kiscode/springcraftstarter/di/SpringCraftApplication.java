package ru.kiscode.springcraftstarter.di;

import org.jetbrains.annotations.NotNull;
import ru.kiscode.springcraftstarter.di.context.SpringBukkitContext;


public class SpringCraftApplication {

    @NotNull
    private final Class<?> startClass;

    public SpringCraftApplication(@NotNull Class<?> startClass) {
        this.startClass = startClass;
    }

    public static void run(@NotNull Class<?> startClass) {
        new SpringCraftApplication(startClass).run();
    }

    public void run(){
        SpringBukkitContext springBukkitContext = new SpringBukkitContext(startClass);
        springBukkitContext.run();
        springBukkitContext.refresh();
    }

}
