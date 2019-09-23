package com.lynu.daoimpl;

import com.lynu.dao.UserDao;
import com.lynu.pojo.User;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UserDaoImpl implements UserDao {
    public SqlSession sqlSession;

    //构造方法
    public UserDaoImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public User findUserById(int user_id) {
        return this.sqlSession.selectOne("UserDaoMapper.findUserById",user_id);
    }

    @Override
    public List<User> findAllUser() {
        return this.sqlSession.selectList("UserDaoMapper.findAllUser");
    }

    @Override
    public void addUser(User user) {
        this.sqlSession.insert("UserDaoMapper.addUser",user);
    }

    @Override
    public void updateUser(User user) {
        this.sqlSession.update("UserDaoMapper.updateUser", user);
    }

    @Override
    public void delUserById(int user_id) {
        this.sqlSession.delete("UserDaoMapper.delUserById",user_id);

    }
}
