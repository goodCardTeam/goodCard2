package com.dytj.leekbox.model;

import java.io.Serializable;

/**
 * Created by MaRufei
 * on 2019-11-17.
 * Email: www.867814102@qq.com
 * Phone：13213580912
 * Purpose:TODO
 * update：
 */
public class RegisterEntity extends JsonResponse implements Serializable {


    /**
     * access_token : eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwOlwvXC8xMjcuMC4wLjE6OTAwNlwvYXBpXC9yZWdpc3RlciIsImlhdCI6MTU3MzA1MDc2OSwiZXhwIjoxNTc1NjQyNzY5LCJuYmYiOjE1NzMwNTA3NjksImp0aSI6Ijh6WThKVEJveVF6UkFTRlkiLCJzdWIiOjEsInBydiI6IjIzYmQ1Yzg5NDlmNjAwYWRiMzllNzAxYzQwMDg3MmRiN2E1OTc2ZjciLCJwYXNzd29yZF9oYXNoIjoiJDJ5JDEwJGxzSDJBeld4c2tXNnRSSFFVOVZLU3VxM1IzWmpSYUpHcUouVzlvYWFzTmRQeTFEUjFDNVJXIn0.8CLN-GMapq3u93EBFe9_ow0Fmj8DJc3sgRNQzeV1fBY
     * token_type : bearer
     * expires_in : 2592000
     * uid : 1
     */

    private String access_token;
    private String token_type;
    private int expires_in;
    private int uid;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getToken_type() {
        return token_type;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }
}
