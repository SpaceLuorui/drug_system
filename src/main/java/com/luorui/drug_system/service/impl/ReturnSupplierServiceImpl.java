package com.luorui.drug_system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.luorui.drug_system.entity.ReturnSupplier;
import com.luorui.drug_system.mapper.ReturnSupplierMapper;
import com.luorui.drug_system.service.ReturnSupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

/**
 * @author 罗锐
 * @date 2023/5/5
 */
@Service
public class ReturnSupplierServiceImpl extends ServiceImpl<ReturnSupplierMapper,ReturnSupplier>implements ReturnSupplierService {
    @Autowired
    private ReturnSupplierMapper returnSupplierMapper;
    /**
     * 分页查询退货给供应商数据
     *
     * @param pageNum  第几页
     * @param pageSize 每页多少条数据
     * @param param    查询参数-退货给供应商名称
     * @return 返回结果
     */
    @Override
    public IPage<ReturnSupplier> selectReturnSupplierPage(int pageNum, int pageSize, String param) {
        QueryWrapper<ReturnSupplier> queryWrapper = new QueryWrapper<>();
        if (!StringUtils.isEmpty(param)){
            //模糊查询
            queryWrapper.like("dname",param);
        }
        Page<ReturnSupplier> page = new Page<>(pageNum,pageSize);
        return returnSupplierMapper.selectPage(page,queryWrapper);
    }

    /**
     * 新增一条退货给供应商信息
     *
     * @param returnSupplier 退货给供应商信息
     * @return 返回结果
     */
    @Override
    public int addReturnSupplier(ReturnSupplier returnSupplier) {
        return returnSupplierMapper.insert(returnSupplier);
    }

    /**
     * 修改一条退货给供应商信息
     *
     * @param returnSupplier 退货给供应商信息
     * @return 返回结果
     */
    @Override
    public int editReturnSupplier(ReturnSupplier returnSupplier) {
        return returnSupplierMapper.updateById(returnSupplier);
    }

    /**
     * 根据主键id查询一个退货给供应商对象
     *
     * @param id id
     * @return 返回结果
     */
    @Override
    public ReturnSupplier queryReturnSupplier(Integer id) {
        return returnSupplierMapper.selectById(id);
    }

    /**
     * 根据主键id删除一个退货给供应商对象
     *
     * @param id
     * @return
     */
    @Override
    public int delReturnSupplier(Integer id) {
        return returnSupplierMapper.deleteById(id);
    }
}
