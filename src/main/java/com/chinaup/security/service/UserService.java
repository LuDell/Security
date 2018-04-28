package com.chinaup.security.service;

import com.chinaup.security.entity.User;

public interface UserService {

    User saveEntity(User record);

    User findById(Integer id);
}
