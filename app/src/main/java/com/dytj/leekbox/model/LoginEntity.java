package com.dytj.leekbox.model;


import java.io.Serializable;

/**
 * Created by zeng on 2018/10/20.
 */

public class LoginEntity extends TradeSimpleResult implements Serializable {


    /**
     * data : {"access_token":"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwOlwvXC8xMTIuNzQuMTI3Ljk5OjUwMTZcL2FwaVwvbG9naW4iLCJpYXQiOjE1NzY4NTYxMTUsImV4cCI6MTU3ODE1MjExNSwibmJmIjoxNTc2ODU2MTE1LCJqdGkiOiJGUDlhcFk2QU9FY0RFVEFlIiwic3ViIjoxLCJwcnYiOiIyM2JkNWM4OTQ5ZjYwMGFkYjM5ZTcwMWM0MDA4NzJkYjdhNTk3NmY3IiwicGFzc3dvcmRfaGFzaCI6IiQyeSQxMCR4UmxGbTAwRk05WjNPV2FoeUw5Znd1Z1FFWlRIQkw1YXdPNGVDdDRjOUtVR0NKenRlb2kyRyJ9.KcH0X2ytT5cBX9bfXdhf06AFifUMPwSNWMlWcdulltg","token_type":"bearer","expires_in":1296000,"uid":1}
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * access_token : eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwOlwvXC8xMTIuNzQuMTI3Ljk5OjUwMTZcL2FwaVwvbG9naW4iLCJpYXQiOjE1NzY4NTYxMTUsImV4cCI6MTU3ODE1MjExNSwibmJmIjoxNTc2ODU2MTE1LCJqdGkiOiJGUDlhcFk2QU9FY0RFVEFlIiwic3ViIjoxLCJwcnYiOiIyM2JkNWM4OTQ5ZjYwMGFkYjM5ZTcwMWM0MDA4NzJkYjdhNTk3NmY3IiwicGFzc3dvcmRfaGFzaCI6IiQyeSQxMCR4UmxGbTAwRk05WjNPV2FoeUw5Znd1Z1FFWlRIQkw1YXdPNGVDdDRjOUtVR0NKenRlb2kyRyJ9.KcH0X2ytT5cBX9bfXdhf06AFifUMPwSNWMlWcdulltg
         * token_type : bearer
         * expires_in : 1296000
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
}
