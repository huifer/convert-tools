package com.github.huifer.ms.ex.model;

import java.util.Objects;

/**
 *
 *
 * @author huifer
 */
public class ParamAndReturnType {

    private Class<?> paramType;

    private Class<?> returnType;


    public ParamAndReturnType() {
    }

    public ParamAndReturnType(Class<?> paramType, Class<?> returnType) {
        this.paramType = paramType;
        this.returnType = returnType;
    }


    @Override
    public String toString() {
        return "ParamAndReturnType{" +
                "paramType=" + paramType +
                ", returnType=" + returnType +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        ParamAndReturnType that = (ParamAndReturnType) o;
        return Objects.equals(paramType, that.paramType) && Objects.equals(returnType, that.returnType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paramType, returnType);
    }

    public Class<?> getParamType() {
        return paramType;
    }

    public void setParamType(Class<?> paramType) {
        this.paramType = paramType;
    }

    public Class<?> getReturnType() {
        return returnType;
    }

    public void setReturnType(Class<?> returnType) {
        this.returnType = returnType;
    }
}
