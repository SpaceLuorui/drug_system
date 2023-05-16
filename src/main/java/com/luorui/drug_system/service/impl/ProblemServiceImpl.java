package com.luorui.drug_system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.luorui.drug_system.entity.Problem;
import com.luorui.drug_system.mapper.ProblemMapper;
import com.luorui.drug_system.service.ProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

/**
 * @author 罗锐
 * @date 2023/5/6
 */
@Service
public class ProblemServiceImpl extends ServiceImpl<ProblemMapper,Problem> implements ProblemService {
    @Autowired
    private ProblemMapper problemMapper;
    /**
     * 分页查询问题药品
     *
     * @param pageNum  第几页
     * @param pageSize 每页数量
     * @param param    参数
     * @return 返回结果
     */
    @Override
    public IPage<Problem> queryProblemPage(int pageNum, int pageSize, String param) {
        QueryWrapper<Problem> queryWrapper = new QueryWrapper<>();
        if(!StringUtils.isEmpty(param)){
            queryWrapper.like("dname",param);
        }
        Page<Problem> page = new Page<>(pageNum,pageSize);
        return problemMapper.selectPage(page,queryWrapper);
    }
    /**
     * 新增
     *
     * @param problem problem
     * @return 返回结果
     */
    @Override
    public int addProblem(Problem problem) {
        return problemMapper.insert(problem);
    }

    /**
     * 修改
     *
     * @param problem problem
     * @return 返回结果
     */
    @Override
    public int editProblem(Problem problem) {
        return problemMapper.updateById(problem);
    }

    /**
     * 根据id查询
     *
     * @param id id
     * @return 返回结果
     */
    @Override
    public Problem queryProblemById(Integer id) {
        return problemMapper.selectById(id);
    }

    /**
     * 根据id查询
     *
     * @param id id
     * @return 返回结果
     */
    @Override
    public int delProblemById(Integer id) {
        return problemMapper.deleteById(id);
    }
}
