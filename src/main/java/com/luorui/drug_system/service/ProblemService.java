package com.luorui.drug_system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.luorui.drug_system.entity.Problem;

/**
 * @author 罗锐
 * @date 2023/5/6
 */
public interface ProblemService extends IService<Problem> {
    //分页查询
    /**
     * 分页查询问题药品
     * @param pageNum 第几页
     * @param pageSize 每页数量
     * @param param 参数
     * @return 返回结果
     */
    IPage<Problem> queryProblemPage(int pageNum,int pageSize, String param);

    /**
     * 新增
     * @param problem problem
     * @return 返回结果
     */
    int addProblem(Problem problem);
    /**
     * 修改
     * @param problem problem
     * @return 返回结果
     */
    int editProblem(Problem problem);
    /**
     * 根据id查询
     * @param id id
     * @return 返回结果
     */
    Problem queryProblemById(Integer id);

    /**
     * 根据id查询
     * @param id id
     * @return 返回结果
     */
    int delProblemById(Integer id);
}
