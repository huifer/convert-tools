package com.github.huifer.convert.think.impl;


import com.github.huifer.convert.think.api.CommonConvert;

public class ConvertOne implements CommonConvert<TestSource, TestTarget> {
    public ConvertOne() {
    }

    @Override
    public TestTarget convert(TestSource source) {
        TestTarget testTarget = new TestTarget();
        testTarget.setUsername(source.getName());
        return testTarget;
    }


}