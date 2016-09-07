package cn.lingban.dubbo.service.impl;

import cn.lingban.dubbo.mapper.UserMapper;
import cn.lingban.dubbo.po.User;
import cn.lingban.dubbo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by heshichao on 16-9-7.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RedisTemplate redisTemplate;

    @Cacheable("ddff")
    @Override
    public User queryUserByName(String username) {
        User user = new User();
        user.setUsername(username);
        redisTemplate.opsForValue().set("ss", "ss");
        return userMapper.selectOne(user);
    }
}
