package com.luorui.drug_system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.luorui.drug_system.entity.User;

/**
 * @author 罗锐
 * @date 2023/4/28
 */
public interface UserService extends IService<User> {
    /**
     * 根据用户姓名查询用户对象
     */
    public User queryUserByUsername(User user);
}
