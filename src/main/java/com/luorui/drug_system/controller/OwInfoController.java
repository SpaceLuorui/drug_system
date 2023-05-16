package com.luorui.drug_system.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.luorui.drug_system.common.ResultMapUtil;
import com.luorui.drug_system.entity.OwInfo;
import com.luorui.drug_system.service.OwInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 罗锐
 * @date 2023/5/6
 */
@Controller
@RequestMapping(value = "/owinfo")
public class OwInfoController {
    @Autowired
    private OwInfoService owInfoService;

    //跳转到药品出入库界面
    @RequestMapping(value = "")
    public String owInfo(){
        return "/owinfo";
    }

    //分页查询
    @RequestMapping(value = "/owinfoQueryPage")
    @ResponseBody
    public Object owInfoQueryPage(String param, @RequestParam(defaultValue = "1")int pageNum, @RequestParam(defaultValue = "10")int pageSize){
        try {
            IPage<OwInfo> iPage = owInfoService.queryOwInfoPage(pageNum,pageSize,param);
            return ResultMapUtil.getHashMapMysqlPage(iPage);
        }catch (Exception exception){
            return ResultMapUtil.getHashMapException(exception);
        }
    }

    //跳转至新增页面
    @RequestMapping("/owinfoPage")
    public String owInfoPage(){
        return "/owinfoPage";
    }
    //新增
    @RequestMapping("/owinfoAdd")
    @ResponseBody
    public Object owInfoAdd(OwInfo owInfo){
        try {
            int i = owInfoService.addOwInfo(owInfo);
            return ResultMapUtil.getHashMapSave(i);
        }catch (Exception exception){
            return ResultMapUtil.getHashMapException(exception);
        }
    }

    //跳转至编辑页面
    @RequestMapping("/owinfoQueryById")
    public String owInfoEdit(@RequestParam(name = "id")Integer id, Model model){
        OwInfo owInfo = owInfoService.queryOwInfoById(id);
        model.addAttribute("obj",owInfo);
        return "/owinfoPage";
    }

    //编辑修改
    @RequestMapping("/owinfoEdit")
    @ResponseBody
    public Object owInfoEdit(OwInfo owInfo){
        try {
            int i = owInfoService.editOwInfo(owInfo);
            return ResultMapUtil.getHashMapSave(i);
        }catch (Exception exception){
            return ResultMapUtil.getHashMapException(exception);
        }
    }

    //删除
    @RequestMapping(value = "/owinfoDelById")
    @ResponseBody
    public Object owInfoDelById(@RequestParam(name = "id")Integer id){
        try {
            int i = owInfoService.delOwInfoById(id);
            return ResultMapUtil.getHashMapDel(i);
        }catch (Exception exception){
            return ResultMapUtil.getHashMapException(exception);
        }
    }
}
