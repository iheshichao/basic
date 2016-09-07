package cn.lingban.dubbo.service;

import cn.lingban.dubbo.po.User;

/**
 * Created by heshichao on 16-9-7.
 */
public interface UserService {

    User queryUserByName(String username);
}
