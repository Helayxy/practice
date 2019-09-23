package cn.lynu.controller;

import cn.lynu.entity.Account;
import cn.lynu.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/*
 * web层
 * */
@Controller //此注解表示spring容器创建该类的实例对象
@RequestMapping("/account")
public class AccountController {
    @Autowired  //此注解表示按照类型自动注入
    private AccountService accountService;

    @RequestMapping("/findAll")
    public String findAll(Model model) {
        System.out.println("表现层：查询所有账户信息...");
        //调用service层的方法
        List<Account> list = accountService.findAll();
        //把list存入model
        model.addAttribute("list", list);
        return "list";
    }

    @RequestMapping("/save")
    public void save(Account account, HttpServletRequest request, HttpServletResponse response) throws IOException {
        accountService.saveAccount(account);
        response.sendRedirect(request.getContextPath()+"/account/findAll");
    }
}
