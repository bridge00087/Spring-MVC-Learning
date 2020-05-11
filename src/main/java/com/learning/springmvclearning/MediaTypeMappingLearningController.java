package com.learning.springmvclearning;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MediaTypeMappingLearningController {

    @RequestMapping(value = "/mediaType",
                    consumes = MediaType.APPLICATION_JSON_VALUE,
                    produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody
    public String mediaType() {
        return "mediaType";
    }
}
