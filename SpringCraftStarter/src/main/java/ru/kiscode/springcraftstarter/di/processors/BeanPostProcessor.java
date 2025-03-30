package ru.kiscode.springcraftstarter.di.processors;

import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public interface BeanPostProcessor {
    @NotNull Object postProcessBeforeInitialization(@NotNull Object bean, @NotNull String beanName, @NotNull JavaPlugin plugin);
    @NotNull Object postProcessAfterInitialization(@NotNull Object bean, @NotNull String beanName, @NotNull JavaPlugin plugin);
}
