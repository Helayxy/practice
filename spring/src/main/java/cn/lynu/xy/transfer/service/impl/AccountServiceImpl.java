package cn.lynu.xy.transfer.service.impl;

import cn.lynu.xy.transfer.dao.AccountDao;
import cn.lynu.xy.transfer.service.AccountService;

public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    //转账
    @Override
    public void transfer(String outer, String inner, Integer money) {
        this.accountDao.out(outer, money);
        this.accountDao.in(inner, money);

    }
}
