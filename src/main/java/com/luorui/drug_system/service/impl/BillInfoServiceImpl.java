package com.luorui.drug_system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.luorui.drug_system.entity.BillInfo;
import com.luorui.drug_system.mapper.BillInfoMapper;
import com.luorui.drug_system.service.BillInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

/**
 * @author 罗锐
 * @date 2023/5/5
 */
@Service
public class BillInfoServiceImpl extends ServiceImpl<BillInfoMapper, BillInfo> implements BillInfoService {
    @Autowired
    private BillInfoMapper billInfoMapper;
    /**
     * 分页查询账单信息
     *
     * @param pageNum  第几页
     * @param pageSize 每页数据量
     * @param param    参数
     * @return 返回结果
     */
    @Override
    public IPage<BillInfo> selectBillInfoPage(int pageNum, int pageSize, String param) {
        QueryWrapper<BillInfo> queryWrapper = new QueryWrapper<>();
        if (!StringUtils.isEmpty(param)){
            //根据供应商名称精准查询
            queryWrapper.eq("sname",param);
        }
        Page<BillInfo> page = new Page<>(pageNum,pageSize);
        return billInfoMapper.selectPage(page,queryWrapper);
    }

    /**
     * 新增一条账单信息
     *
     * @param billInfo 账单信息
     * @return 返回结果
     */
    @Override
    public int addBillInfo(BillInfo billInfo) {
        return billInfoMapper.insert(billInfo);
    }

    /**
     * 修改一条账单信息
     *
     * @param billInfo 账单信息
     * @return 返回结果
     */
    @Override
    public int editBillInfo(BillInfo billInfo) {
        return billInfoMapper.updateById(billInfo);
    }

    /**
     * 根据id查询账单信息
     *
     * @param id id
     * @return 返回结果
     */
    @Override
    public BillInfo queryBillInfoById(Integer id) {
        return billInfoMapper.selectById(id);
    }

    /**
     * 根据id删除账单信息
     *
     * @param id id
     * @return 返回结果
     */
    @Override
    public int delBillInfoById(Integer id) {
        return billInfoMapper.deleteById(id);
    }
}
