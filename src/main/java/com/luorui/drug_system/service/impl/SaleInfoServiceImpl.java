package com.luorui.drug_system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.luorui.drug_system.entity.SaleInfo;
import com.luorui.drug_system.mapper.SaleInfoMapper;
import com.luorui.drug_system.service.SaleInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

/**
 * @author 罗锐
 * @date 2023/5/6
 */
@Service
public class SaleInfoServiceImpl extends ServiceImpl<SaleInfoMapper,SaleInfo>implements SaleInfoService {
    @Autowired
    private SaleInfoMapper saleInfoMapper;
    @Override
    public IPage<SaleInfo> querySaleInfoPage(int pageNum, int pageSize, String param) {
        QueryWrapper<SaleInfo> queryWrapper = new QueryWrapper<>();
        if (!StringUtils.isEmpty(param)){
            queryWrapper.like("dname",param);
        }
        Page<SaleInfo> page = new Page<>(pageNum,pageSize);
        return saleInfoMapper.selectPage(page,queryWrapper);
    }

    @Override
    public int addSaleInfo(SaleInfo saleInfo) {
        return saleInfoMapper.insert(saleInfo);
    }

    @Override
    public int editSaleInfo(SaleInfo saleInfo) {
        return saleInfoMapper.updateById(saleInfo);
    }

    @Override
    public SaleInfo querySaleInfoById(Integer id) {
        return saleInfoMapper.selectById(id);
    }

    @Override
    public int delSaleInfoById(Integer id) {
        return saleInfoMapper.deleteById(id);
    }
}
