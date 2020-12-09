package com.github.huifer.convert.impl;

import java.lang.reflect.Constructor;

import com.github.huifer.convert.api.ConvertRegister;
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

        C1 c1 = new C1();
        convertRegister.register(c1);


        S s = new S();
        s.setName("张三");

        T convert = ConvertFacade.convert(s, T.class);
        Assert.assertEquals(convert.getUsername(), "张三");

    }


    @Test
    public void register2() throws InstantiationException, IllegalAccessException {

        convertRegister.register(C1.class);


        S s = new S();
        s.setName("张三");

        T convert = ConvertFacade.convert(s, T.class);
        Assert.assertEquals(convert.getUsername(), "张三");

    }



}