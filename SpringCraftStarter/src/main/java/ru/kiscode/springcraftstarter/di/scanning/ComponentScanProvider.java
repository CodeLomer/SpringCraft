package ru.kiscode.springcraftstarter.di.scanning;

import org.jetbrains.annotations.NotNull;
import ru.kiscode.springcraftstarter.di.annotation.Component;
import ru.kiscode.springcraftstarter.di.annotation.ComponentScan;
import ru.kiscode.springcraftstarter.di.filter.TypeFilter;
import ru.kiscode.springcraftstarter.di.filter.impl.AnnotationFilterType;
import ru.kiscode.springcraftstarter.di.filter.impl.AssignableFilterType;
import ru.kiscode.springcraftstarter.di.filter.impl.RegexFilterType;
import ru.kiscode.springcraftstarter.di.metadata.ResourceMetadata;
import ru.kiscode.springcraftstarter.di.resource.ResourceLoader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ComponentScanProvider {
    private final List<TypeFilter> includeFilters = new ArrayList<>();
    private final List<TypeFilter> excludeFilters = new ArrayList<>();

    @NotNull
    private final ResourceLoader resourceLoader;

    public ComponentScanProvider(@NotNull ComponentScan componentScan, @NotNull ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;

        if (componentScan.useDefaultFilters()) {
            registerDefaultFilters();
        }

        registerFilters(componentScan.includeFilters(), includeFilters);
        registerFilters(componentScan.excludeFilters(), excludeFilters);
    }

    public ComponentScanProvider(@NotNull ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
        registerDefaultFilters();
    }



    private void registerDefaultFilters() {
        includeFilters.add(new AnnotationFilterType(Component.class));
    }


    public Collection<ResourceMetadata> getClassMetadataList(String... basePackages) {
        return resourceLoader.getResourceMetadataList(basePackages).stream()
                .filter(this::matchesIncludeFilters)
                .filter(this::matchesExcludeFilters)
                .collect(Collectors.toList());
    }

    private void registerFilters(@NotNull ComponentScan.Filter[] filters, List<TypeFilter> filterList) {
        filterList.addAll(Arrays.stream(filters)
                .flatMap(filter -> createTypeFilters(filter).stream())
                .collect(Collectors.toList()));
    }

    private boolean matchesIncludeFilters(@NotNull ResourceMetadata resourceMetadata) {
        return includeFilters.isEmpty() || includeFilters.stream().anyMatch(filter -> filter.matches(resourceMetadata, resourceLoader));
    }

    private boolean matchesExcludeFilters(@NotNull ResourceMetadata resourceMetadata) {
        return excludeFilters.stream().noneMatch(filter -> filter.matches(resourceMetadata, resourceLoader));
    }

    private Collection<TypeFilter> createTypeFilters(ComponentScan.Filter filter) {
        List<TypeFilter> filters = new ArrayList<>();
        switch (filter.type()) {
            case ANNOTATION:
                filters.add(new AnnotationFilterType(Arrays.asList(filter.annotations())));
                break;
            case ASSIGNABLE_TYPE:
                filters.add(new AssignableFilterType(Arrays.asList(filter.assignableClasses())));
                break;
            case REGEX:
                filters.add(new RegexFilterType(Arrays.asList(filter.patterns())));
                break;
            case CUSTOM:
                filters.addAll(Arrays.stream(filter.customFilters()).map(this::createCustomFilter).collect(Collectors.toList()));
        }
        return filters;
    }

    private TypeFilter createCustomFilter(Class<? extends TypeFilter> filterClass) {
        //TODO create filter instance
        return null;
    }
}
