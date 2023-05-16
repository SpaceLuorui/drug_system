package com.luorui.drug_system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.luorui.drug_system.entity.OwInfo;

/**
 * @author 罗锐
 * @date 2023/5/6
 */
//药品出入库
public interface OwInfoService extends IService<OwInfo> {
    //分页查询出入库信息
    IPage<OwInfo> queryOwInfoPage(int pageNum, int pageSize, String param);
    //新增
    int addOwInfo(OwInfo owInfo);
    //编辑
    int editOwInfo(OwInfo owInfo);
    //通过id查询
    OwInfo queryOwInfoById(Integer id);
    //删除
    int delOwInfoById(Integer id);
}
