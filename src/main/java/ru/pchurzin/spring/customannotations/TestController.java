package ru.pchurzin.spring.customannotations;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/test")
public class TestController {

    public static final String HANDLE_REQUEST_WITH_PARAMS = "handleRequestWithParams";
    public static final String HANDLE_REQUEST_WITHOUT_PARAMS = "handleRequestWithoutParams";

    @GetMapping
    @ResponseBody
    public String handleRequestWithParams(Map<String, String> params) {
        return HANDLE_REQUEST_WITH_PARAMS;
    }

    @GetMapping
    @ResponseBody
    @NoRequestParams
    public String handleRequestWithoutParams() {
        return HANDLE_REQUEST_WITHOUT_PARAMS;
    }
}
