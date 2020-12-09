package com.github.huifer.convert.model;

import java.util.Objects;

/**
 *
 *
 * @author huifer
 */
public class ConvertSourceAndTarget {

    /**
     * {@link com.github.huifer.convert.api.Convert} 中的 S
     */
    private Class<?> sourceTypeClass;

    /**
     * {@link com.github.huifer.convert.api.Convert} 中的 T
     */
    private Class<?> targetTypeClass;

    public ConvertSourceAndTarget(Class<?> sourceTypeClass, Class<?> targetTypeClass) {
        this.sourceTypeClass = sourceTypeClass;
        this.targetTypeClass = targetTypeClass;
    }

    public ConvertSourceAndTarget() {
    }

    @Override
    public String toString() {
        return "ConvertSourceAndTarget{" +
                "sourceTypeClass=" + sourceTypeClass +
                ", targetTypeClass=" + targetTypeClass +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        ConvertSourceAndTarget that = (ConvertSourceAndTarget) o;
        return Objects.equals(sourceTypeClass, that.sourceTypeClass) && Objects.equals(targetTypeClass, that.targetTypeClass);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sourceTypeClass, targetTypeClass);
    }

    public Class<?> getSourceTypeClass() {
        return sourceTypeClass;
    }

    public void setSourceTypeClass(Class<?> sourceTypeClass) {
        this.sourceTypeClass = sourceTypeClass;
    }

    public Class<?> getTargetTypeClass() {
        return targetTypeClass;
    }

    public void setTargetTypeClass(Class<?> targetTypeClass) {
        this.targetTypeClass = targetTypeClass;
    }
}
