package com.spring.condition;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportSelector implements ImportSelector {

    public String[] selectImports(AnnotationMetadata importingClassMetadata) {

        return new String[]{"com.spring.pojo.Blue","com.spring.pojo.Yellow"};
    }
}
