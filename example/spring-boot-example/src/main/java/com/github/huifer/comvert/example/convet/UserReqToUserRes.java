package com.github.huifer.comvert.example.convet;

import com.github.huifer.comvert.example.entity.req.UserReq;
import com.github.huifer.comvert.example.entity.res.UserRes;
import com.github.huifer.comvert.example.service.Aservice;
import com.github.huifer.convert.think.api.CommonConvert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 *
 * @author huifer
 */
@Service
public class UserReqToUserRes implements CommonConvert<UserReq, UserRes> {
    @Autowired
    private Aservice aservice;

    @Override
    public UserRes convert(UserReq source) {
        UserRes userRes = new UserRes();
        userRes.setUsername(aservice.a());
        return userRes;
    }
}
