package com.luorui.drug_system.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.luorui.drug_system.common.ResultMapUtil;
import com.luorui.drug_system.entity.Supplier;
import com.luorui.drug_system.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * @author 罗锐
 * @date 2023/5/4
 */
@Controller
@RequestMapping(value = "/supplier")
public class SupplierController {
    @Autowired
    private SupplierService supplierService;

    /**
     * @return 转向供应商页面
     */
    @RequestMapping(value = "")
    public String supplier(){
        return "/supplier";
    }

    /**
     * 分页查询供应商列表
     * @param param 供应商参数
     * @param page 第几页
     * @param limit 每页数据量
     * @return 返回结果
     */
    @RequestMapping(value = "/supplierQueryPage")
    @ResponseBody
    public Object supplierQueryPage(String param, @RequestParam(defaultValue = "1")int page, @RequestParam(defaultValue = "10")int limit){
        try{
            IPage<Supplier> iPage = supplierService.selectSupplierPage(page,limit,param);
            return ResultMapUtil.getHashMapMysqlPage(iPage);
        }catch (Exception exception){
            return ResultMapUtil.getHashMapException(exception);
        }
    }

    /**
     * @return 转向供应商页面
     */
    @RequestMapping(value = "/supplierPage")
    public String supplierPage(){
        return "/supplierPage";
    }

    /**
     * 新增一个供应商
     * @param supplier 供应商
     * @return 返回结果
     */
    @RequestMapping(value = "supplierAdd")
    @ResponseBody
    public Object supplierAdd(Supplier supplier){
        try{
            supplier.setCreatetime(new Date());
            int i = supplierService.addSupplier(supplier);
            return ResultMapUtil.getHashMapSave(i);
        }catch (Exception exception){
            return ResultMapUtil.getHashMapException(exception);
        }
    }

    /**
     * @param id id
     * @param model model
     * @return 转向供应商编辑页面
     */
    @RequestMapping(value = "/supplierQueryById")
    public String supplierQueryById(@RequestParam(name = "id",required = true)Integer id, Model model){
        Supplier supplier = supplierService.querySupplierById(id);
        //把查询到的供应商信息放到编辑页面
        model.addAttribute("obj",supplier);
        return "/supplierPage";
    }

    /**
     * 修改一个供应商
     * @param supplier 供应商
     * @return 返回结果
     */
    @RequestMapping(value = "/supplierEdit")
    @ResponseBody
    public Object supplierEdit(Supplier supplier){
        try{
            int i = supplierService.editSupplier(supplier);
            return ResultMapUtil.getHashMapSave(i);
        }catch (Exception exception){
            return ResultMapUtil.getHashMapException(exception);
        }
    }

    /**
     * 删除一个供应商
     * @param id id
     * @return 返回结果
     */
    @RequestMapping(value = "/supplierDelById")
    @ResponseBody
    public Object supplierDelById(Integer id){
        try {
            int i = supplierService.delSupplierById(id);
            return ResultMapUtil.getHashMapDel(i);
        }catch (Exception exception){
            return ResultMapUtil.getHashMapException(exception);
        }
    }

    /**
     *
     * @return 返回所有供应商
     */
    @RequestMapping(value = "/supplierList")
    @ResponseBody
    public Object supplierList(){
        List<Supplier> supplierList = supplierService.querySupplierList();
        return ResultMapUtil.getHashMapList(supplierList);
    }
}
