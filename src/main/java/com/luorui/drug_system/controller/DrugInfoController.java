package com.luorui.drug_system.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.luorui.drug_system.common.ResultMapUtil;
import com.luorui.drug_system.entity.DrugInfo;
import com.luorui.drug_system.service.DrugInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author 罗锐
 * @date 2023/5/4
 */
@Controller
@RequestMapping(value = "/druginfo")
public class DrugInfoController {
    @Autowired
    private DrugInfoService drugInfoService;

    /**
     * @return  转向药品页面
     */
    @RequestMapping(value = "")
    public String drugInfo(){
        return "/druginfo";
    }
    //@RequestParam可以通过@RequestParam(“userId”)或者@RequestParam(value = “userId”)指定传入的参数名
    //@RequestParam可以通过@RequestParam(defaultValue = “0”)指定参数默认值
    @RequestMapping(value = "druginfoQueryPage")
    @ResponseBody
    public Object drugInfoQueryPage(String param, @RequestParam(defaultValue = "1")int page, @RequestParam(defaultValue = "10")int limit){
        try {
            IPage<DrugInfo> iPage = drugInfoService.selectDrugInfoPage(page,limit,param);
            return ResultMapUtil.getHashMapMysqlPage(iPage);
        }catch (Exception exception){
            return ResultMapUtil.getHashMapException(exception);
        }
    }

    /**
     * @return 转向药品新增界面
     */
    @RequestMapping(value = "/druginfoPage")
    public String drugInfoPage(){
        return "/druginfoPage";
    }

    /**
     * 新增一个药品
     * @param drugInfo 药品
     * @return 返回添加成功的数量
     */
    @RequestMapping(value = "druginfoAdd")
    @ResponseBody
    public Object drugInfoAdd(DrugInfo drugInfo){
        try{
            int i = drugInfoService.addDrugInfo(drugInfo);
            return ResultMapUtil.getHashMapSave(i);
        }catch (Exception exception){
            return ResultMapUtil.getHashMapException(exception);
        }
    }
    /**
     * 转向药品编辑页面
     */
    @RequestMapping(value = "/druginfoQueryById")
    public String drugInfoQueryById(@RequestParam(name = "id",required = true)Integer id, Model model){
        DrugInfo drugInfo = drugInfoService.queryDrugInfoById(id);
        model.addAttribute("obj",drugInfo);
        return "/druginfoPage";
    }
    /**
     * 编辑修改一个药品
     * @param drugInfo 药品信息
     * @return 返回结果
     */
    @RequestMapping(value = "/druginfoEdit")
    @ResponseBody
    public Object drugInfoEdit(DrugInfo drugInfo){
        try{
            int i = drugInfoService.editDrugInfo(drugInfo);
            return ResultMapUtil.getHashMapSave(i);
        }catch (Exception exception){
            return ResultMapUtil.getHashMapException(exception);
        }
    }

    /**
     * 删除一个药品
     * @param id 药品id
     * @return 返回结果
     */
    @RequestMapping(value = "/druginfoDelById")
    @ResponseBody
    public Object drugInfoDelById(Integer id){
        try{
            int i = drugInfoService.deleteDrugInfoById(id);
            return ResultMapUtil.getHashMapDel(i);
        }catch (Exception exception){
            return ResultMapUtil.getHashMapException(exception);
        }
    }

    /**
     * 获取所有的药品信息
     * @return 返回结果
     */
    @RequestMapping(value = "druginfoList")
    @ResponseBody
    public Object drugInfoList(){
        List<DrugInfo> drugInfoList = drugInfoService.queryDrugInfoList();
        return ResultMapUtil.getHashMapList(drugInfoList);
    }

    @RequestMapping(value = "/warranty")
    public String warranty(){
        return "/warranty";
    }
}
