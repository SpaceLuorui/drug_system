package com.luorui.drug_system.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.luorui.drug_system.common.ResultMapUtil;
import com.luorui.drug_system.entity.BillInfo;
import com.luorui.drug_system.service.BillInfoService;
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
@RequestMapping(value = "/billinfo")
public class BillInfoController {
    @Autowired
    private BillInfoService billInfoService;

    /**
     *
     * @return 转向账单信息页面
     */
    @RequestMapping(value = "")
    public String billInfo(){
        return "/billinfo";
    }

    /**
     * 分页查询账单信息列表
     * @param param 参数
     * @param page 第几页
     * @param limit 每页数据量
     * @return 返回结果
     */
    @RequestMapping(value = "billinfoQueryPage")
    @ResponseBody
    public Object billInfoQueryPage(String param, @RequestParam(defaultValue = "1")int page, @RequestParam(defaultValue = "10")int limit){
        try{
            IPage<BillInfo> iPage = billInfoService.selectBillInfoPage(page,limit,param);
            return ResultMapUtil.getHashMapMysqlPage(iPage);
        }catch (Exception exception){
            return ResultMapUtil.getHashMapException(exception);
        }
    }

    /**
     *
     * @return 转向账单信息新增页面
     */
    @RequestMapping(value = "/billinfoPage")
    public String billInfoPage(){
        return "/billinfoPage";
    }

    /**
     * 新增账单信息
     * @param billInfo 账单信息
     * @return 返回结果
     */
    @RequestMapping(value = "billinfoAdd")
    @ResponseBody
    public Object billInfoAdd(BillInfo billInfo){
        try {
            billInfo.setBuytime(new Date());
            int i = billInfoService.addBillInfo(billInfo);
            return ResultMapUtil.getHashMapSave(i);
        }catch (Exception exception){
            return ResultMapUtil.getHashMapException(exception);
        }
    }

    /**
     *
     * @param id 根据id查询选中的账单信息
     * @param model 把查询到的账单信息放入单编辑页面
     * @return 转向账单信息编辑页面
     */
    @RequestMapping(value = "/billinfoQueryById")
    public String billInfoQueryById(@RequestParam(name = "id")Integer id, Model model){
        BillInfo billInfo = billInfoService.queryBillInfoById(id);
        model.addAttribute("obj",billInfo);
        return "/billinfoPage";
    }

    /**
     * 修改账单信息
     * @param billInfo 账单信息
     * @return 返回结果
     */
    @RequestMapping(value = "/billinfoEdit")
    @ResponseBody
    public Object billInfoEdit(BillInfo billInfo){
        try {
            int i = billInfoService.editBillInfo(billInfo);
            return ResultMapUtil.getHashMapSave(i);
        }catch (Exception exception){
            return ResultMapUtil.getHashMapException(exception);
        }
    }

    /**
     * 删除一个账单信息
     * @param id id
     * @return 返回结果
     */
    @RequestMapping(value = "/billinfoDelById")
    @ResponseBody
    public Object billInfoDelById(Integer id){
        try{
            int i = billInfoService.delBillInfoById(id);
            return ResultMapUtil.getHashMapDel(i);
        }catch (Exception exception){
            return ResultMapUtil.getHashMapException(exception);
        }
    }
}
