package com.priv.controller;

import com.priv.ants.CheckToken;
import com.priv.ants.CheckToken2;
import com.priv.model.result.GraceJsonResult;
import com.priv.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Json
 * @date 2021/3/1 22:28
 */
@RestController
@RequestMapping("/token")
public class TokenController {

    private final TokenService tokenService;

    @Autowired
    public TokenController(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @GetMapping("/createToken")
    public GraceJsonResult createToken() {

        // 创建token
        tokenService.createToken();

        return GraceJsonResult.success();
    }

    @CheckToken
    @GetMapping("/checkToken")
    public GraceJsonResult checkToken() {
        return GraceJsonResult.success("测试");
    }

    @CheckToken2
    @GetMapping("/checkToken2")
    public GraceJsonResult checkToken2() {
        return GraceJsonResult.success("测试");
    }
}
