package com.dytj.leekbox.model;

import java.io.Serializable;

/**
 * Created by zeng on 2017/9/20.
 * Introduction: 交易系统基础返回实体类
 */

public class JsonResponse<T> implements Serializable{

  int code;
  String msg;
  T data;

  @Override
  public String toString() {
    return "JsonResponse{" +
            "code=" + code +
            ", msg='" + msg + '\'' +
            ", data=" + data +
            '}';
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

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

