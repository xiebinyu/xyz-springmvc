package com.xyz.sm.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Config {

  @Value("${qq}")
  private String qq;

  public String getQq() {
    return qq;
  }

  public void setQq(String qq) {
    this.qq = qq;
  }
}
