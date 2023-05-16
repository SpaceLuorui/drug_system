package com.luorui.drug_system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.luorui.drug_system.entity.OwInfo;
import com.luorui.drug_system.mapper.OwInfoMapper;
import com.luorui.drug_system.service.OwInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

/**
 * @author 罗锐
 * @date 2023/5/6
 */
/*药品出入库*/
@Service
public class OwInfoServiceImpl extends ServiceImpl<OwInfoMapper,OwInfo>implements OwInfoService {
    @Autowired
    private OwInfoMapper owInfoMapper;
    @Override
    public IPage<OwInfo> queryOwInfoPage(int pageNum, int pageSize, String param) {
        QueryWrapper<OwInfo> queryWrapper = new QueryWrapper<>();
        if (!StringUtils.isEmpty(param)){
            queryWrapper.like("dname",param);
        }
        Page<OwInfo> page = new Page<>(pageNum,pageSize);
        return owInfoMapper.selectPage(page,queryWrapper);
    }

    @Override
    public int addOwInfo(OwInfo owInfo) {
        return owInfoMapper.insert(owInfo);
    }

    @Override
    public int editOwInfo(OwInfo owInfo) {
        return owInfoMapper.updateById(owInfo);
    }

    @Override
    public OwInfo queryOwInfoById(Integer id) {
        return owInfoMapper.selectById(id);
    }

    @Override
    public int delOwInfoById(Integer id) {
        return owInfoMapper.deleteById(id);
    }
}
