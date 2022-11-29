package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.*;


@Controller
@Slf4j
@RequestMapping("thyme")
public class ThymeleafController {

    @GetMapping("hello")
    public String hello(Model model, HttpServletRequest request) { // model 把 request 数据带到视图里面去
        // 输出字符串
        String stranger = "Jack";
        model.addAttribute("there", stranger);

        // 输出格式化的日期
        Date birthDay = new Date();
        model.addAttribute("birthDay", birthDay);

        // sex 性别 用于判断
        Integer sex = 2;
        model.addAttribute("sex", sex);

        // list
        List<String> myList = new ArrayList<>();
        myList.add("1001");
        myList.add("1002");
        myList.add("1003");
        model.addAttribute("myList", myList);

        // map
        Map<String, Object> myMap = new HashMap<>();
        myMap.put("id", "30033");
        myMap.put("age", 18);
        myMap.put("sex", "boy");
        myMap.put("name", "风间影月");
        model.addAttribute("myMap", myMap);

        request.setAttribute("enName", "abcxyz");
        request.getSession().setAttribute("userToken", UUID.randomUUID().toString());

        return "teacher";
    }


}
