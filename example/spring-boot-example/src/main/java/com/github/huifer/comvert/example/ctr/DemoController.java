package com.github.huifer.comvert.example.ctr;

import com.github.huifer.comvert.example.entity.req.UserReq;
import com.github.huifer.comvert.example.entity.res.UserRes;
import com.github.huifer.convert.think.impl.ConvertFacade;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 *
 * @author huifer
 */
@RestController
@RequestMapping
public class DemoController {

    @PostMapping("/demo")
    public Object demo(
            @RequestBody UserReq userReq
    ) {
        return ConvertFacade.convert(userReq, UserRes.class);
    }
}
