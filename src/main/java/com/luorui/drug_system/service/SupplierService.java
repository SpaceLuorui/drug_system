package com.luorui.drug_system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.luorui.drug_system.entity.Supplier;

import java.util.List;

/**
 * @author 罗锐
 * @date 2023/5/4
 */
public interface SupplierService extends IService<Supplier> {

    /**
     * 分页查询供应商
     * @param pageNum 第几页
     * @param pageSize 每页数据量
     * @param Param 查询参数-供应商名称
     * @return 返回结果
     */
    IPage<Supplier> selectSupplierPage(int pageNum, int pageSize, String Param);

    /**
     * 新增一条供应商信息
     * @param supplier 供应商
     * @return 返回结果
     */
    int addSupplier(Supplier supplier);

    /**
     * 修改一条供应商信息
     * @param supplier 供应商
     * @return 返回结果
     */
    int editSupplier(Supplier supplier);

    /**
     * 根据id查询供应商信息
     * @param id id
     * @return 返回结果
     */
    Supplier querySupplierById(Integer id);

    /**
     * 根据id删除供应商信息
     * @param id id
     * @return 返回结果
     */
    int delSupplierById(Integer id);

    /**
     * 查询所有供应商
     * @return 返回List集合
     */
    List<Supplier> querySupplierList();
}
