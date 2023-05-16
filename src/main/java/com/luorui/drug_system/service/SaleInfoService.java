package com.luorui.drug_system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.luorui.drug_system.entity.SaleInfo;

/**
 * @author 罗锐
 * @date 2023/5/6
 */
public interface SaleInfoService extends IService<SaleInfo> {
    //分页查询
    IPage<SaleInfo> querySaleInfoPage(int pageNum, int pageSize, String param);

    //新增
    int addSaleInfo(SaleInfo saleInfo);
    //编辑修改
    int editSaleInfo(SaleInfo saleInfo);
    //根据id查询
    SaleInfo querySaleInfoById(Integer id);
    //根据id删除
    int delSaleInfoById(Integer id);
}
