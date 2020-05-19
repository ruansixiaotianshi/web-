package com.fb.core.service;


import com.fb.core.entity.AdminUser;

public interface AdminUserService {

    AdminUser login(String userName, String password);

}
