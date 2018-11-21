package com.xyz.sm.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogInterceptor implements HandlerInterceptor {

  /**
   * 预处理回调方法，实现处理器的预处理（如登录检查）
   */
  public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
    System.out.println("controller访问开始！");
    return true;
  }

  /**
   * 后处理回调方法，实现处理器的后处理（但在渲染视图之前）
   */
  public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
    System.out.println("controller访问结束，开始渲染！");
  }

  /**
   * 整个请求处理完毕回调方法，即在视图渲染完毕时回调
   */
  public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    System.out.println("controller渲染结束！");
  }
}
