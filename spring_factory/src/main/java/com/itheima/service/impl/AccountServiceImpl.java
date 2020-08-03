package com.itheima.service.impl;

import com.itheima.dao.IAccountDao;
import com.itheima.dao.impl.AccountDaoImpl;
import com.itheima.service.IAccountService;

/**
 * @author wangzeya
 * @create 2020-08-03 15:37:00
 * 账户的业务层实现类(业务层调用持久层)
 */
public class AccountServiceImpl implements IAccountService {
    private IAccountDao accountDao=new AccountDaoImpl();

    public void saveAccount() {
        accountDao.saveAccount();
    }

}
