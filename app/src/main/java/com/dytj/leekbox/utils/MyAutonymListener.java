package com.dytj.leekbox.utils;

import com.dytj.leekbox.model.TradeSimpleResult;


/**
 * Created by dell on 2017/12/1.
 */

public abstract class MyAutonymListener  {
  public void onSuccessful(TradeSimpleResult accountInfoEntity){}
  public void onFailure(){}
}
