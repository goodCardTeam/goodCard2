package com.dytj.leekbox.utils;

import com.dytj.leekbox.model.JsonResponse;


/**
 * Created by dell on 2017/12/1.
 */

public abstract class MyAutonymListener  {
  public void onSuccessful(JsonResponse accountInfoEntity){}
  public void onFailure(){}
}
