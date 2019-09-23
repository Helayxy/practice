package cn.lynu.xy.ioc.webannotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller("studentAction")//创建名称为studentAction的bean
public class StudentAction {
    @Autowired//默认按照类型注入
    private StudentService studentService;
    public void execute() {
        studentService.addStudent();
    }
}
