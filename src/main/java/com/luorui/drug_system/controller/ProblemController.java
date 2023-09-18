package com.luorui.drug_system.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.luorui.drug_system.common.ResultMapUtil;
import com.luorui.drug_system.entity.Problem;
import com.luorui.drug_system.service.ProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
/**
 * @author 罗锐
 * @date 2023/5/6
 */
@Controller
@RequestMapping(value = "/problem")
public class ProblemController {
    @Autowired
    private ProblemService problemService;

    @RequestMapping(value = "")
    public String problem() {
        return "/problem";
    }

    //分页查询
    @RequestMapping(value = "/problemQueryPage")
    @ResponseBody
    public Object queryProblemPage(String param, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int limit) {
        try {
            IPage<Problem> iPage = problemService.queryProblemPage(page, limit, param);
            return ResultMapUtil.getHashMapMysqlPage(iPage);
        } catch (Exception exception) {
            return ResultMapUtil.getHashMapException(exception);
        }
    }

    //跳转至新增界面
    @RequestMapping(value = "/problemPage")
    public String problemPage() {
        return "/problemPage";
    }

    //新增
    @RequestMapping(value = "problemAdd")
    @ResponseBody
    public Object problemAdd(Problem problem) {
        try {
            problem.setCreatetime(new Date());
            int i = problemService.addProblem(problem);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception exception) {
            return ResultMapUtil.getHashMapException(exception);
        }
    }

    //跳转至编辑界面
    @RequestMapping(value = "/problemQueryById")
    public String problemQueryById(@RequestParam(name = "id") Integer id, Model model) {
        Problem problem = problemService.queryProblemById(id);
        model.addAttribute("obj", problem);
        return "/problemPage";
    }

    //编辑
    @RequestMapping(value = "/problemEdit")
    @ResponseBody
    public Object problemEdit(Problem problem) {
        try {
            int i = problemService.editProblem(problem);
            return ResultMapUtil.getHashMapSave(i);
        }catch (Exception exception){
            return ResultMapUtil.getHashMapException(exception);
        }
    }

    //删除
    @RequestMapping(value = "/problemDelById")
    @ResponseBody
    public Object problemDelById(Integer id){
        try {
            int i = problemService.delProblemById(id);
            return ResultMapUtil.getHashMapDel(i);
        }catch (Exception exception){
            return ResultMapUtil.getHashMapException(exception);
        }
    }
}