package cn.lynu.xy.ioc.webannotation;

import org.springframework.stereotype.Repository;

@Repository("studentDao")//按照名称注入
public class StudentDaoImpl implements StudentDao {
    @Override
    public void save() {
        System.out.println("dao");
    }
}
