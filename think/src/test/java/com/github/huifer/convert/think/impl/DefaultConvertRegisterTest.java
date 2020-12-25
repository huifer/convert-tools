package com.github.huifer.convert.think.impl;

import com.github.huifer.convert.think.api.ConvertRegister;
import com.github.huifer.convert.think.start.CommonConvertRunner;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 *
 * @author huifer
 */
public class DefaultConvertRegisterTest {
    ConvertRegister convertRegister = new DefaultConvertRegister();

    @Test
    public void register() {

        ConvertOne convertOne = new ConvertOne();
        convertRegister.register(convertOne);


        TestSource testSource = new TestSource();
        testSource.setName("张三");

        TestTarget convert = ConvertFacade.convert(testSource, TestTarget.class);
        Assert.assertEquals(convert.getUsername(), "张三");

    }


    @Test
    public void register2() throws InstantiationException, IllegalAccessException {

        convertRegister.register(ConvertOne.class);


        TestSource testSource = new TestSource();
        testSource.setName("张三");

        TestTarget convert = ConvertFacade.convert(testSource, TestTarget.class);
        Assert.assertEquals(convert.getUsername(), "张三");

    }


    @Test
    public void register3() {
        CommonConvertRunner.start(new String[] {"com.github.huifer.convert.think"});

        TestSource testSource = new TestSource();
        testSource.setName("张三");

        TestTarget convert = ConvertFacade.convert(testSource, TestTarget.class);
        Assert.assertEquals(convert.getUsername(), "张三");
    }

}