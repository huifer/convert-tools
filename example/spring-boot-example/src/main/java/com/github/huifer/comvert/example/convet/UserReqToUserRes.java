package com.github.huifer.comvert.example.convet;

import com.github.huifer.comvert.example.entity.req.UserReq;
import com.github.huifer.comvert.example.entity.res.UserRes;
import com.github.huifer.convert.think.api.CommonConvert;

/**
 *
 *
 * @author huifer
 */
public class UserReqToUserRes implements CommonConvert<UserReq, UserRes> {
    @Override
    public UserRes convert(UserReq source) {
        UserRes userRes = new UserRes();
        userRes.setUsername(source.getUsername());
        return userRes;
    }
}
