package io.fresh.controllers;


import io.fresh.bean.Greeting;
import io.fresh.entity.SysUser;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class SampleController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/")
    @ResponseBody
    public String home() {

        return "Hello World!";
    }

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @RequestMapping("/sysuser")
    public String user(Model m){
        List<SysUser> list = new ArrayList<SysUser>();
        SysUser u1 = new SysUser(1, "hello1", "11111111111111111");
        SysUser u2 = new SysUser(2, "hello2", "22222222222222222");
        SysUser u3 = new SysUser(3, "hello3", "33333333333333333");

        list.add(u1);
        list.add(u2);
        list.add(u3);

        m.addAttribute("userList", list);
        m.addAttribute("sysUser", "SysUser");

        return "sysuser";
    }


}
