package com.luorui.drug_system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.luorui.drug_system.entity.Supplier;
import com.luorui.drug_system.mapper.SupplierMapper;
import com.luorui.drug_system.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import java.util.List;

/**
 * @author 罗锐
 * @date 2023/5/4
 */
@Service
public class SupplierServiceImpl extends ServiceImpl<SupplierMapper, Supplier> implements SupplierService {
    @Autowired
    private SupplierMapper supplierMapper;
    /**
     * 分页查询供应商
     *
     * @param pageNum  第几页
     * @param pageSize 每页数据量
     * @param param    查询参数-供应商名称
     * @return 返回结果
     */
    @Override
    public IPage<Supplier> selectSupplierPage(int pageNum, int pageSize, String param) {
        QueryWrapper<Supplier> queryWrapper = new QueryWrapper<>();
        if (!StringUtils.isEmpty(param)){
            queryWrapper.like("name",param);
        }
        Page<Supplier> page = new Page<>(pageNum,pageSize);
        return supplierMapper.selectPage(page,queryWrapper);
    }

    /**
     * 新增一条供应商信息
     * @param supplier 供应商
     * @return 返回结果
     */
    @Override
    public int addSupplier(Supplier supplier) {
        return supplierMapper.insert(supplier);
    }

    /**
     * 修改一条供应商信息
     *
     * @param supplier 供应商
     * @return 返回结果
     */
    @Override
    public int editSupplier(Supplier supplier) {
        return supplierMapper.updateById(supplier);
    }

    /**
     * 根据id查询供应商信息
     *
     * @param id id
     * @return 返回结果
     */
    @Override
    public Supplier querySupplierById(Integer id) {
        return supplierMapper.selectById(id);
    }

    /**
     * 根据id删除供应商信息
     *
     * @param id id
     * @return 返回结果
     */
    @Override
    public int delSupplierById(Integer id) {
        return supplierMapper.deleteById(id);
    }

    /**
     * 查询所有供应商
     *
     * @return 返回List集合
     */
    @Override
    public List<Supplier> querySupplierList() {
        return supplierMapper.selectList(null);
    }
}
