package com.github.huifer.comvert.example.convet;

import com.github.huifer.comvert.example.entity.req.UserReq;
import com.github.huifer.comvert.example.entity.res.UserRes2;
import com.github.huifer.convert.think.api.CommonConvert;

/**
 *
 *
 * @author huifer
 */
public class UserReqToUserRes2 implements CommonConvert<UserReq, UserRes2> {

    @Override
    public UserRes2 convert(UserReq source) {
        UserRes2 userRes = new UserRes2();
        userRes.setUsername("bbb");
        return userRes;
    }
}
