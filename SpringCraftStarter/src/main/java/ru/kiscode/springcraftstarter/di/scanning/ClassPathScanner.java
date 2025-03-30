package ru.kiscode.springcraftstarter.di.scanning;

import org.jetbrains.annotations.NotNull;
import ru.kiscode.springcraftstarter.di.annotation.ComponentScan;
import ru.kiscode.springcraftstarter.di.definition.AnnotatedBeanDefinition;
import ru.kiscode.springcraftstarter.di.metadata.AnnotationMetadata;
import ru.kiscode.springcraftstarter.di.metadata.ResourceMetadata;
import ru.kiscode.springcraftstarter.di.registry.BeanDefinitionRegistry;
import ru.kiscode.springcraftstarter.di.resource.ResourceLoader;
import ru.kiscode.springcraftstarter.di.resource.ResourceLoaderSupport;

import java.util.HashSet;
import java.util.Set;

public class ClassPathScanner implements ResourceLoaderSupport {

    @NotNull
    private final BeanDefinitionRegistry beanDefinitionRegistry;
    @NotNull
    private ResourceLoader resourceLoader;

    public ClassPathScanner(@NotNull BeanDefinitionRegistry beanDefinitionRegistry, @NotNull ResourceLoader resourceLoader) {
        this.beanDefinitionRegistry = beanDefinitionRegistry;
        this.resourceLoader = resourceLoader;
    }

    public void scan(@NotNull String basePackage) {
        scan(new String[]{basePackage});
    }

    public void scan(String... basePackages) {
        Set<ResourceMetadata> metadataSet = new HashSet<>();
        Set<String> visitedPackages = new HashSet<>();
        ComponentScanProvider componentScanProvider = new ComponentScanProvider(resourceLoader);
        findResourceMetadata(metadataSet, visitedPackages, componentScanProvider, basePackages);

        //TODO Регистрация найденных классов в BeanDefinitionRegistry (если нужно)
        for (ResourceMetadata metadata : metadataSet) {
            AnnotatedBeanDefinition annotatedBeanDefinition = new AnnotatedBeanDefinition(metadata);
            if(beanDefinitionRegistry.containsBeanDefinition(annotatedBeanDefinition)) {
                throw new IllegalStateException("Bean with name " + annotatedBeanDefinition.getBeanName() + " already exists");
            }
            beanDefinitionRegistry.registerBeanDefinition(annotatedBeanDefinition);
        }
    }

    private void findResourceMetadata(Set<ResourceMetadata> metadataSet, Set<String> visitedPackages,
                                      ComponentScanProvider componentScanProvider, String... basePackages) {
        Set<ResourceMetadata> foundMetadata = new HashSet<>(componentScanProvider.getClassMetadataList(basePackages));

        for (ResourceMetadata metadata : foundMetadata) {
            // Добавляем метаданные, если они еще не были добавлены
            if (metadataSet.add(metadata)) {

                // Если у нас есть аннотация @ComponentScan, то сканируем дополнительные пакеты
                if (metadata.getAnnotationMetadata().hasAnnotation(ComponentScan.class)) {
                    ComponentScan componentScan = metadata.getAnnotationMetadata().getAnnotation(ComponentScan.class);

                    // Проверяем, чтобы не сканировать уже посещенные пакеты
                    for (String newBasePackage : componentScan.packages()) {
                        if (!visitedPackages.contains(newBasePackage)) {
                            visitedPackages.add(newBasePackage);
                            componentScanProvider = new ComponentScanProvider(componentScan, resourceLoader);
                            metadataSet.addAll(componentScanProvider.getClassMetadataList(newBasePackage));
                            findResourceMetadata(metadataSet, visitedPackages, componentScanProvider, newBasePackage);
                        }
                    }
                }
            }
        }
    }

    @Override
    public void setResourceLoader(@NotNull ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @Override
    public @NotNull ResourceLoader getResourceLoader() {
        return resourceLoader;
    }
}
