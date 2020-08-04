package com.itheima.ui;

import com.itheima.factory.BeanFactory;
import com.itheima.service.IAccountService;
import com.itheima.service.impl.AccountServiceImpl;

/**
 * @author wangzeya
 * @create 2020-08-03 16:09:00
 * 模拟一个表现层，用来调用业务层
 */
public class Client {
    public static void main(String[] args) {
        //IAccountService as = new AccountServiceImpl();
        IAccountService as = (IAccountService) BeanFactory.getBean("accountService");
        ((AccountServiceImpl) as).saveAccount();

    }

}
