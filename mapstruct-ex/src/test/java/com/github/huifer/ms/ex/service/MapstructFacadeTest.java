package com.github.huifer.ms.ex.service;

import java.util.ArrayList;
import java.util.List;

import com.github.huifer.convert.mapstruct.model.UserEntity;
import com.github.huifer.convert.mapstruct.model.UserTarget;
import com.github.huifer.convert.mapstruct.model.UserTarget2;
import com.github.huifer.convert.mapstruct.smaple.UserConvert;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 *
 * @author huifer
 */
public class MapstructFacadeTest {


    @Test
    public void t1() throws Exception {
        // 1. 加载数据
        List<Class<?>> mappings = new ArrayList<>();
        mappings.add(UserConvert.class);
        ScanPackage.loadMappings(mappings);

        UserEntity userEntity = new UserEntity();
        userEntity.setName("张三");
        UserTarget convert = MapstructFacade.convert(userEntity, UserTarget.class);

        Assert.assertEquals(convert.getUsername(), "张三");
        Assert.assertEquals(convert.getName(), "张三");


        UserTarget2 convert2 = MapstructFacade.convert(userEntity, UserTarget2.class);
        Assert.assertEquals(convert2.getCnName(), "张三");


    }
}