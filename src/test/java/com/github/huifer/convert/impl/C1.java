package com.github.huifer.convert.impl;

import com.github.huifer.convert.api.Convert;

public class C1 implements Convert<S, T> {
    public C1() {
    }

    @Override
    public T convert(S source) {
        T t = new T();
        t.setUsername(source.getName());
        return t;
    }
}