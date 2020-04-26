package com.learning.springmvclearning;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UriPatternMappingLearningController {
    // URI パターン
    /*
    ?：一文字
    *：複数文字
    **：複数パス
    {name: }：正規表現
     */
    @GetMapping("/uri1/?")
    @ResponseBody
    public String uri1() {
        return "uri1";
    }

    @GetMapping("/uri2/*")
    @ResponseBody
    public String uri2() {
        return "uri2";
    }

    @GetMapping("/uri3/**")
    @ResponseBody
    public String uri3() {
        return "uri3";
    }

    @RequestMapping("/uri4//{name:[a-z]+}")
    @ResponseBody
    public String uri4(@PathVariable String name) {
        return "uri4 " + name;
    }
}
