package cn.lynu.xy.transfer.dao.impl;

import cn.lynu.xy.transfer.dao.AccountDao;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {
    @Override
    public void out(String outer, Integer money) {
        this.getJdbcTemplate().update("UPDATE account SET balance = balance - ? WHERE username = ?", money, outer);
    }

    @Override
    public void in(String inner, Integer money) {
        this.getJdbcTemplate().update("UPDATE account SET balance = balance + ? WHERE username = ?", money, inner);
    }
}
