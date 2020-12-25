package com.github.huifer.convert.forspring.importselector;

import java.util.Map;

import com.github.huifer.convert.forspring.annotation.EnableCommonConvert;
import com.github.huifer.convert.think.start.CommonConvertRunner;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 *
 *
 * @author huifer
 */
public class CommonConvertImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {

        Map<String, Object> annotationAttributes = annotationMetadata
                .getAnnotationAttributes(EnableCommonConvert.class.getName());
        String[] scanPackages = (String[]) annotationAttributes.get("scanPackages");
        CommonConvertRunner.start(scanPackages);
        return new String[0];
    }
}
