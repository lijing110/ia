package com.njfu.wa.sys.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sys/help")
public class HelpController {

    /**
     * 帮助文档页
     *
     * @return page
     */
    @RequestMapping
    public String document() {
        return "sys/help/document";
    }
}
