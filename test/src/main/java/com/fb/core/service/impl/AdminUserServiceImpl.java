package com.fb.core.service.impl;

import com.fb.core.dao.AdminUserMapper;
import com.fb.core.entity.AdminUser;
import com.fb.core.service.AdminUserService;
import com.fb.core.util.MD5Util;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AdminUserServiceImpl implements AdminUserService {

    @Resource
    private AdminUserMapper adminUserMapper;

    @Override
    public AdminUser login(String userName, String password) {
        String passwordMd5 = MD5Util.MD5Encode(password, "UTF-8");
        return adminUserMapper.login(userName, passwordMd5);
    }
}
