package com.chinaup.security.service.impl;

import com.chinaup.security.dao.UserDao;
import com.chinaup.security.entity.User;
import com.chinaup.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    @CachePut(value = "user",key = "#record.id")
    public User saveEntity(User record) {
        return userDao.save(record);
    }

    @Override
    @Cacheable(value = "user",key = "#id")
    public User findById(Integer id) {
        return userDao.findById(id).get();
    }
}
