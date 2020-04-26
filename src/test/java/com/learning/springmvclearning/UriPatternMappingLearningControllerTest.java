package com.learning.springmvclearning;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest
class UriPatternMappingLearningControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("URI パターン： ?：一文字")
    public void uriTest1() throws Exception {
        mockMvc.perform(get("/uri1/a"))
                .andDo(print())
                .andExpect(status().isOk());

        mockMvc.perform(get("/uri1/b"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("URI パターン：*：複数文字")
    public void uriTest2() throws Exception {
        mockMvc.perform(get("/uri2/aaa"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("URI パターン：**：複数パス")
    public void uriTest3() throws Exception {
        mockMvc.perform(get("/uri3/test/hello"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("URI パターン：{name: }：正規表現")
    public void uriTest4() throws Exception {
        mockMvc.perform(get("/uri4/test"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("uri4 test"))
                .andExpect(handler().handlerType(UriPatternMappingLearningController.class))
                .andExpect(handler().methodName("uri4"));
    }

    @Test
    @DisplayName("URI拡張マッピングテスト：NG")
    public void uriTest5() throws Exception {
        mockMvc.perform(get("/uri4/test.xml"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }
}