package com.luorui.drug_system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.luorui.drug_system.entity.DrugInfo;
import com.luorui.drug_system.mapper.DrugInfoMapper;
import com.luorui.drug_system.service.DrugInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import java.util.List;

/**
 * @author 罗锐
 * @date 2023/5/4
 */
@Service
public class DrugInfoServiceImpl extends ServiceImpl<DrugInfoMapper, DrugInfo> implements DrugInfoService {
    @Autowired
    private DrugInfoMapper drugInfoMapper;
    /**
     * 分页查询药品数据
     *
     * @param pageNum  第几页
     * @param pageSize 每页多少条数据
     * @param param    查询参数-药品名称
     * @return 返回药品信息
     */
    @Override
    public IPage<DrugInfo> selectDrugInfoPage(int pageNum, int pageSize, String param) {
        QueryWrapper<DrugInfo> queryWrapper = new QueryWrapper<>();
        if (!StringUtils.isEmpty(param)){
            queryWrapper.like("name",param);
        }
        Page<DrugInfo> page = new Page<>(pageNum,pageSize);
        return drugInfoMapper.selectPage(page,queryWrapper);
    }

    /**
     * 新增一条药品信息
     * @param drugInfo 药品信息
     * @return 返回新增成功的数量
     */
    @Override
    public int addDrugInfo(DrugInfo drugInfo) {
        return drugInfoMapper.insert(drugInfo);
    }

    /**
     * 修改药品信息
     *
     * @param drugInfo 药品信息
     * @return 返回修改成功的数量
     */
    @Override
    public int editDrugInfo(DrugInfo drugInfo) {
        return drugInfoMapper.updateById(drugInfo);
    }

    /**
     * 根据主键id查询一个药品对象
     *
     * @param id id
     * @return 返回一个药品信息
     */
    @Override
    public DrugInfo queryDrugInfoById(Integer id) {
        return drugInfoMapper.selectById(id);
    }

    /**
     * 根据主键id删除一个药品对象
     *
     * @param id id
     * @return 返回删除成功的数量
     */
    @Override
    public int deleteDrugInfoById(Integer id) {
        return drugInfoMapper.deleteById(id);
    }

    /**
     * 查询所有药品
     *
     * @return 返回药品信息集合
     */
    @Override
    public List<DrugInfo> queryDrugInfoList() {
        return drugInfoMapper.selectList(null);
    }
}
