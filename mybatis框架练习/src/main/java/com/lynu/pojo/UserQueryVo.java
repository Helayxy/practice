package com.lynu.pojo;

public class UserQueryVo {
    /*这个类叫包装类型
    * 这个类用来包装所需的查询条件
    * 可以包装很多需要的条件
    * */
    //用户查询条件
    private UserCustom userCustom;

    public UserCustom getUserCustom() {
        return userCustom;
    }

    public void setUserCustom(UserCustom userCustom) {
        this.userCustom = userCustom;
    }
}
