package ru.kiscode.springcraftstarter.di.context;


import org.jetbrains.annotations.NotNull;

public class SpringBukkitContext implements ApplicationContext {

    @NotNull
    private final Class<?> startClass;

    public SpringBukkitContext(@NotNull Class<?> startClass){
        this.startClass = startClass;
    }

    @Override
    public void run() {

    }

    @Override
    public void refresh() {

    }
}
