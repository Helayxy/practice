package com.lynu.dao;

import com.lynu.pojo.User;
import com.lynu.pojo.UserCustom;
import com.lynu.pojo.UserQueryVo;

import java.util.List;

public interface UserMapper {
    public User findUserById(int id);

    public void delUserById(int id);

    public List<UserCustom> findUserList(UserQueryVo userQueryVo);

    public int findUserCount(UserQueryVo userQueryVo) throws Exception;

    public User findUserByIdResultMap(int id);

    public User findUserByIdCommonSql(int id);

    //测试if，查询sex为1（男性）的用户，如果输入了姓名，则按姓名查询
    public List<User> findUserListif(String user_name);
    /*
     * 查询所有用户，如果输入了姓名按照姓名进行模糊查询，
     * 如果输入年龄，按照年龄进行查询，如果两者都输入，
     * 两个条件都要成立
     * */
    public List<User> findUserByNameAndSex(String name,int sex);

}
