package ru.kiscode.springcraftstarter.di.annotation;

import ru.kiscode.springcraftstarter.di.filter.FilterType;
import ru.kiscode.springcraftstarter.di.filter.TypeFilter;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ComponentScan {
    String[] packages() default {};
    Filter[] includeFilters() default {};
    Filter[] excludeFilters() default {};
    boolean useDefaultFilters() default true;


    @Retention(RetentionPolicy.RUNTIME)
    @Target({})
    @interface Filter {
        FilterType type() default FilterType.ANNOTATION;
        Class<?>[] assignableClasses() default {};
        String[] patterns() default {};
        Class<? extends Annotation>[] annotations() default {};
        Class<? extends TypeFilter>[] customFilters() default {};
    }
}
