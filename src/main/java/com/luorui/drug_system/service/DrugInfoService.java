package com.luorui.drug_system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.luorui.drug_system.entity.DrugInfo;

import java.util.List;

/**
 * @author 罗锐
 * @date 2023/5/4
 */
public interface DrugInfoService extends IService<DrugInfo> {
    /**
     * 分页查询药品数据
     * @param pageNum 第几页
     * @param pageSize 每页多少条数据
     * @param param 查询参数-药品名称
     * @return 返回药品信息
     */
    IPage<DrugInfo> selectDrugInfoPage(int pageNum, int pageSize, String param);

    /**
     * 修改药品信息
     * @param drugInfo 药品信息
     * @return 返回修改成功的数量
     */
    /**
     * 新增一条药品信息
     * @param drugInfo 药品信息
     * @return 返回新增成功的数量
     */
    int addDrugInfo(DrugInfo drugInfo);
    int editDrugInfo(DrugInfo drugInfo);

    /**
     * 根据主键id查询一个药品对象
     * @param id id
     * @return 返回一个药品信息
     */
    DrugInfo queryDrugInfoById(Integer id);

    /**
     * 根据主键id删除一个药品对象
     * @param id id
     * @return 返回删除成功的数量
     */
    int deleteDrugInfoById(Integer id);

    /**
     * 查询所有药品
     * @return 返回药品信息集合
     */
    List<DrugInfo> queryDrugInfoList();
}
