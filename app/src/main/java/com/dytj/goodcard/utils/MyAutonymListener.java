package com.dytj.goodcard.utils;

import com.dytj.goodcard.model.JsonResponse;


/**
 * Created by dell on 2017/12/1.
 */

public abstract class MyAutonymListener  {
  public void onSuccessful(JsonResponse accountInfoEntity){}
  public void onFailure(){}
}
