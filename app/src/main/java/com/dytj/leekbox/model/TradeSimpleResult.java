package com.dytj.leekbox.model;

import java.io.Serializable;

/**
 * Created by zeng on 2017/9/20.
 * Introduction: 交易系统基础返回实体类
 */

public class TradeSimpleResult implements Serializable{

  int code;
  String msg;

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }
}

