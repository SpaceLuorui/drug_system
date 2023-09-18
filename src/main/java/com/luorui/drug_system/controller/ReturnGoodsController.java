package com.luorui.drug_system.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.luorui.drug_system.common.ResultMapUtil;
import com.luorui.drug_system.entity.ReturnGoods;
import com.luorui.drug_system.service.ReturnGoodsService;
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
@RequestMapping(value = "/returngoods")
public class ReturnGoodsController {
    @Autowired
    private ReturnGoodsService returnGoodsService;

    /**
     * 转向收到退货页面
     */
    @RequestMapping(value = "")
    public String returnGoods(){
        return "/returngoods";
    }

    /**
     * 分页查询收到退货列表
     */
    @RequestMapping(value = "/returngoodsQueryPage")
    @ResponseBody
    public Object returnGoodsQueryPage(String param, @RequestParam(defaultValue = "1")int page, @RequestParam(defaultValue = "10")int limit){
        try{
            IPage<ReturnGoods> iPage = returnGoodsService.queryReturnGoodsPage(page,limit,param);
            return ResultMapUtil.getHashMapMysqlPage(iPage);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 转向收到退货新增页面
     */
    @RequestMapping(value = "/returngoodsPage")
    public String returnGoodsPage(){
        return "/returngoodsPage";
    }

    /**
     * 添加一个收到退货
     */
    @RequestMapping(value = "/returngoodsAdd")
    @ResponseBody
    public Object returnGoodsAdd(ReturnGoods returnGoods){
        try{
            returnGoods.setOperatetime(new Date());
            int i = returnGoodsService.addReturnGoods(returnGoods);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 转向收到退货编辑页面
     */
    @RequestMapping(value = "/returngoodsQueryById")
    public String returnGoodsQueryById(@RequestParam(name = "id",required = true)Integer id, Model model){
        ReturnGoods returnGoods = returnGoodsService.queryReturnGoodsById(id);
        model.addAttribute("obj",returnGoods);
        return "/returngoodsPage";
    }

    /**
     * 修改一个收到退货
     */
    @RequestMapping(value = "/returngoodsEdit")
    @ResponseBody
    public Object returnGoodsEdit(ReturnGoods returngoods){
        try{
            int i = returnGoodsService.editReturnGoods(returngoods);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 删除一个收到退货
     */
    @RequestMapping(value = "/returngoodsDelById")
    @ResponseBody
    public Object returnGoodsDelById(Integer id){
        try{
            int i = returnGoodsService.delReturnGoodsById(id);
            return ResultMapUtil.getHashMapDel(i);
        } catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }

}
