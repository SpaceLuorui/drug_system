package com.luorui.drug_system;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.luorui.drug_system.common.ResultMapUtil;
import com.luorui.drug_system.entity.Problem;
import com.luorui.drug_system.entity.User;
import com.luorui.drug_system.mapper.ProblemMapper;
import com.luorui.drug_system.mapper.UserMapper;
import com.luorui.drug_system.service.ProblemService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@SpringBootTest
class DrugSystemApplicationTests {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ProblemMapper problemMapper;

    @Autowired
    private ProblemService problemService;
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
    @Test
    void pageTest(){
        int pageNum = 1;
        int pageSize = 10;
        String param = null;
        IPage<Problem> problemIPage = problemService.queryProblemPage(pageNum,pageSize,param);
        problemIPage.getRecords().forEach(System.out::println);
    }
}
