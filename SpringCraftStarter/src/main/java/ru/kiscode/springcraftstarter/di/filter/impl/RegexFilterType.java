package ru.kiscode.springcraftstarter.di.filter.impl;

import ru.kiscode.springcraftstarter.di.filter.TypeFilter;
import ru.kiscode.springcraftstarter.di.metadata.ResourceMetadata;
import ru.kiscode.springcraftstarter.di.resource.ResourceLoader;

import java.util.Collection;


public class RegexFilterType implements TypeFilter {


    private final Collection<String> regex;

    public RegexFilterType(Collection<String> regex) {
        this.regex = regex;
    }

    @Override
    public boolean matches(ResourceMetadata resourceMetadata, ResourceLoader resourceLoader) {
        return regex.stream().anyMatch(regex -> resourceMetadata.getClassMetadata().getClassName().matches(regex));
    }
}
