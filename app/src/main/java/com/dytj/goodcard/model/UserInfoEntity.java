package com.dytj.goodcard.model;

/**
 * Created by MaRufei
 * on 2020-03-09.
 * Email: www.867814102@qq.com
 * Phone：13213580912
 * Purpose:TODO
 * update：
 */
public class UserInfoEntity {


    /**
     * user : {"tel":"152****5510","avatar_url":"http://127.0.0.1:9006/uploads/20200215/rAyjN1ulwzymqNWskjDCldaXV9dc5LX6.jpg","nickname":"啦啦啦","invite_code":"WYJQ2S","point":11250,"locked_point":0,"is_verified":0}
     */

    private UserBean user;

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public static class UserBean {
        /**
         * tel : 152****5510
         * avatar_url : http://127.0.0.1:9006/uploads/20200215/rAyjN1ulwzymqNWskjDCldaXV9dc5LX6.jpg
         * nickname : 啦啦啦
         * invite_code : WYJQ2S
         * point : 11250
         * locked_point : 0
         * is_verified : 0
         */

        private String tel;
        private String avatar_url;
        private String nickname;
        private String invite_code;
        private int point;
        private int locked_point;
        private int is_verified;

        public String getTel() {
            return tel;
        }

        public void setTel(String tel) {
            this.tel = tel;
        }

        public String getAvatar_url() {
            return avatar_url;
        }

        public void setAvatar_url(String avatar_url) {
            this.avatar_url = avatar_url;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getInvite_code() {
            return invite_code;
        }

        public void setInvite_code(String invite_code) {
            this.invite_code = invite_code;
        }

        public int getPoint() {
            return point;
        }

        public void setPoint(int point) {
            this.point = point;
        }

        public int getLocked_point() {
            return locked_point;
        }

        public void setLocked_point(int locked_point) {
            this.locked_point = locked_point;
        }

        public int getIs_verified() {
            return is_verified;
        }

        public void setIs_verified(int is_verified) {
            this.is_verified = is_verified;
        }
    }

}
