package cn.lingban.dubbo.service.impl;

import cn.lingban.dubbo.mapper.UserMapper;
import cn.lingban.dubbo.po.User;
import cn.lingban.dubbo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by heshichao on 16-9-7.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public User queryUserByName(String username) {
        User user = new User();
        user.setUsername(username);
        return userMapper.selectOne(user);
    }

}
