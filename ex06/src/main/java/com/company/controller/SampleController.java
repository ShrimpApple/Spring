package com.company.controller;

import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Log4j
@RequestMapping("/sample/")
@Controller
public class SampleController {

    @GetMapping("/all")
    public void doAll(){
        log.info("do all can access everybody");
    }

    @GetMapping("/member")
    public void doMember(){
        log.info("logined member");
    }

    @GetMapping("/admin")
    public void doAdmin(){
        log.info("admin only");
    }
}
