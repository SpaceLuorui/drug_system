package com.luorui.drug_system.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.luorui.drug_system.common.ResultMapUtil;
import com.luorui.drug_system.entity.ReturnSupplier;
import com.luorui.drug_system.service.ReturnSupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * @author 罗锐
 * @date 2023/5/5
 */
@Controller
@RequestMapping(value = "/returnsupplier")
public class ReturnSupplierController {
    @Autowired
    private ReturnSupplierService returnSupplierService;
    /**
     * 转向退货给供应商页面
     */
    @RequestMapping(value = "")
    public String returnSupplier(){
        return "/returnsupplier";
    }
    /**
     * 分页查询退货给供应商列表
     */
    @RequestMapping(value = "/returnsupplierQueryPage")
    @ResponseBody
    public Object returnSupplierQueryPage(String param, @RequestParam(defaultValue = "1")int page, @RequestParam(defaultValue = "10")int limit){
        try {
            IPage<ReturnSupplier> iPage = returnSupplierService.selectReturnSupplierPage(page,limit,param);
            return ResultMapUtil.getHashMapMysqlPage(iPage);
        }catch (Exception exception){
            return ResultMapUtil.getHashMapException(exception);
        }
    }
    /**
     * 转向退货给供应商新增页面
     */
    @RequestMapping(value = "/returnsupplierPage")
    public String returnSupplierPage(){
        return "/returnsupplierPage";
    }
    /**
     * 添加一个退货给供应商
     */
    @RequestMapping(value = "/returnsupplierAdd")
    @ResponseBody
    public Object returnSupplierAdd(ReturnSupplier returnSupplier){
        try{
            returnSupplier.setCreatetime(new Date());
            int i = returnSupplierService.addReturnSupplier(returnSupplier);
            return ResultMapUtil.getHashMapSave(i);
        }catch (Exception exception){
            return ResultMapUtil.getHashMapException(exception);
        }
    }
    /**
     * 转向退货给供应商编辑页面
     */
    @RequestMapping(value = "/returnsupplierQueryById")
    public String returnSupplierQueryById(@RequestParam(name = "id")Integer id, Model model){
        ReturnSupplier returnSupplier = returnSupplierService.queryReturnSupplier(id);
        model.addAttribute("obj",returnSupplier);
        return "/returnsupplierPage";
    }
    /**
     * 修改一个退货给供应商
     */
    @RequestMapping(value = "/returnsupplierEdit")
    @ResponseBody
    public Object returnSupplierEdit(ReturnSupplier returnSupplier){
        try {
            int i = returnSupplierService.editReturnSupplier(returnSupplier);
            return ResultMapUtil.getHashMapSave(i);
        }catch (Exception exception){
            return ResultMapUtil.getHashMapException(exception);
        }
    }
    /**
     * 删除一个退货给供应商
     */
    @RequestMapping("/returnsupplierDelById")
    @ResponseBody
    public Object returnSupplierDelById(Integer id){
        try {
            int i = returnSupplierService.delReturnSupplier(id);
            return ResultMapUtil.getHashMapDel(i);
        }catch (Exception exception){
            return ResultMapUtil.getHashMapException(exception);
        }
    }
}
