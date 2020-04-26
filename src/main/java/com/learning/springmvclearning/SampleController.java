package com.learning.springmvclearning;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SampleController {

    // 全てのリクエスト許可する。
    /*
    @RequestMapping("/hello")
    */

    // GET, PUTのリクエストのみ許可する。
    @RequestMapping(value = "/hello", method = {RequestMethod.GET, RequestMethod.PUT})


    // リターン値をHTTP Response Bodyに直接書く
    @ResponseBody

    public String hello() {
        return "hello";
    }
}
