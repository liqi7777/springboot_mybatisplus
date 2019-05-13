package com.example.springboot_mybatisplus.service.impl;

import com.example.springboot_mybatisplus.model.User;
import com.example.springboot_mybatisplus.mapper.UserMapper;
import com.example.springboot_mybatisplus.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liqi
 * @since 2019-05-13
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
