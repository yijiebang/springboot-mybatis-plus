package com.www.jjy.service.impl;

import com.www.jjy.entity.User;
import com.www.jjy.mapper.UserMapper;
import com.www.jjy.service.IUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Jerry
 * @since 2019-07-31
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
