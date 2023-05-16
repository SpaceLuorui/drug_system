package com.luorui.drug_system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.luorui.drug_system.entity.ReturnSupplier;

/**
 * @author 罗锐
 * @date 2023/5/5
 */
public interface ReturnSupplierService extends IService<ReturnSupplier> {
    /**
     * 分页查询退货给供应商数据
     * @param pageNum 第几页
     * @param pageSize 每页多少条数据
     * @param param 查询参数-退货给供应商名称
     * @return 返回结果
     */
    IPage<ReturnSupplier> selectReturnSupplierPage(int pageNum, int pageSize, String param);

    /**
     * 新增一条退货给供应商信息
     * @param returnSupplier 退货给供应商信息
     * @return 返回结果
     */
    int addReturnSupplier(ReturnSupplier returnSupplier);

    /**
     * 修改一条退货给供应商信息
     * @param returnSupplier 退货给供应商信息
     * @return 返回结果
     */
    int editReturnSupplier(ReturnSupplier returnSupplier);
    /**
     * 根据主键id查询一个退货给供应商对象
     * @param id id
     * @return 返回结果
     */
    ReturnSupplier queryReturnSupplier(Integer id);
    /**
     * 根据主键id删除一个退货给供应商对象
     * @param id
     * @return
     */
    int delReturnSupplier(Integer id);
}
