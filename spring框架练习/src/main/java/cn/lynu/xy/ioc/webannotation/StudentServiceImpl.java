package cn.lynu.xy.ioc.webannotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service    //service层创建bean
public class StudentServiceImpl implements StudentService {
    private StudentDao studentDao;
    @Autowired
    @Qualifier("studentDao")
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }
    @Override
    public void addStudent() {
        studentDao.save();
    }
}
