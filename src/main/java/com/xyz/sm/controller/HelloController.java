package com.xyz.sm.controller;

import com.xyz.sm.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

  @Autowired
  private Config config;

  // 父容器中的bean(对象)对controller是可见的，但是父容器加载的属性变量只是对父容器spring本身中的对象可见；
  // 所以controller使用 @Value注解无法在子容器springMVC中获得对应的属性值，只能取得容器赋予的默认值。
  @Value("${qq}")
  private String qq;

  @ResponseBody
  @RequestMapping("/sayHello")
  public String sayHello(String name) {
    return name + ", 你好！";
  }

  @ResponseBody
  @RequestMapping("/showQQ")
  public String showQQ() {
    return config.getQq();
  }

  @RequestMapping("/hello")
  public ModelAndView hello(String name) {
    ModelAndView mv = new ModelAndView();
    mv.addObject("name", name);
    mv.setViewName("hello");
    return mv;
  }
}
