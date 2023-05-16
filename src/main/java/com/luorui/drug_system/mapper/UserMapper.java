package com.luorui.drug_system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.luorui.drug_system.entity.User;
import org.springframework.stereotype.Repository;


/**
 * @author 罗锐
 * @date 2023/4/27
 */
/**
 * 用户表的增删改查Mapper
 */
@Repository
//告诉容器你是持久层的 @Repository是spring提供的注释，能够将该类注册成Bean
public interface UserMapper extends BaseMapper<User> {
}
