package com.luorui.drug_system;

import com.luorui.drug_system.entity.User;
import com.luorui.drug_system.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DrugSystemApplicationTests {
    @Autowired
    private UserMapper userMapper;
    @Test
    void testSelect() {
        System.out.println("===测试===");
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }
    @Test
    void testInsert(){
        User user = new User();
        user.setId(3);
        user.setUsername("安慕希");
        user.setPassword("0427");
        int res = userMapper.insert(user);
        System.out.println("res = " + res);
        System.out.println(user);
    }

}
