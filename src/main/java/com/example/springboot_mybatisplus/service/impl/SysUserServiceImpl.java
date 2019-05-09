package com.example.springboot_mybatisplus.service.impl;

import com.example.springboot_mybatisplus.model.SysUser;
import com.example.springboot_mybatisplus.mapper.SysUserMapper;
import com.example.springboot_mybatisplus.service.SysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统用户 服务实现类
 * </p>
 *
 * @author liqi
 * @since 2019-05-09
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

}
