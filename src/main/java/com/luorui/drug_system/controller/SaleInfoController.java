package com.luorui.drug_system.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.luorui.drug_system.common.ResultMapUtil;
import com.luorui.drug_system.entity.SaleInfo;
import com.luorui.drug_system.service.SaleInfoService;
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
@RequestMapping(value = "/saleinfo")
public class SaleInfoController {
    @Autowired
    private SaleInfoService saleInfoService;
    //跳转到销售记录页面
    @RequestMapping(value = "")
    public String saleInfo(){
        return "/saleinfo";
    }
    //分页查询
    @RequestMapping(value = "/saleinfoQueryPage")
    @ResponseBody
    public Object saleInfoQueryPage(String param, @RequestParam(defaultValue = "1")int page, @RequestParam(defaultValue = "10")int limit){
        try {
            IPage<SaleInfo> iPage = saleInfoService.querySaleInfoPage(page,limit,param);
            return ResultMapUtil.getHashMapMysqlPage(iPage);
        }catch (Exception exception){
            return ResultMapUtil.getHashMapException(exception);
        }
    }
    //跳转至新增页面
    @RequestMapping(value = "/saleinfoPage")
    public String saleinfoPage(){
        return "/saleinfoPage";
    }
    //新增
    @RequestMapping(value = "/saleinfoAdd")
    @ResponseBody
    public Object saleInfoAdd(SaleInfo saleInfo){
        try {
            saleInfo.setOperatetime(new Date());
            int i = saleInfoService.addSaleInfo(saleInfo);
            return ResultMapUtil.getHashMapSave(i);
        }catch (Exception exception){
            return ResultMapUtil.getHashMapException(exception);
        }
    }
    //跳转至编辑页面
    @RequestMapping(value = "/saleinfoQueryById")
    public String saleInfoQueryById(@RequestParam(name = "id")Integer id, Model model){
        SaleInfo saleInfo = saleInfoService.querySaleInfoById(id);
        model.addAttribute("obj",saleInfo);
        return "/saleinfoPage";
    }
    //编辑
    @RequestMapping(value = "/saleinfoEdit")
    @ResponseBody
    public Object saleInfoEdit(SaleInfo saleInfo){
        try {
            int i = saleInfoService.editSaleInfo(saleInfo);
            return ResultMapUtil.getHashMapSave(i);
        }catch (Exception exception){
            return ResultMapUtil.getHashMapException(exception);
        }
    }
    //删除
    @RequestMapping(value = "saleinfoDelById")
    @ResponseBody
    public Object saleInfoDelById(@RequestParam(name = "id")int id){
        try{
            int i = saleInfoService.delSaleInfoById(id);
            return ResultMapUtil.getHashMapDel(i);
        }catch (Exception exception){
            return ResultMapUtil.getHashMapException(exception);
        }
    }
}
