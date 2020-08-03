package com.itheima.dao.impl;

import com.itheima.dao.IAccountDao;

/**
 * @author wangzeya
 * @create 2020-08-03 15:50:00
 * 账户的持久层实现类
 */
public class AccountDaoImpl implements IAccountDao {

    public void saveAccount(){
        System.out.println("保存了账户");
    }
}
