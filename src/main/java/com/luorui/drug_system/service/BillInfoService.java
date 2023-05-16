package com.luorui.drug_system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.luorui.drug_system.entity.BillInfo;

/**
 * @author 罗锐
 * @date 2023/5/5
 */

//账单信息的service接口
public interface BillInfoService extends IService<BillInfo> {
    /**
     * 分页查询账单信息
     * @param pageNum 第几页
     * @param pageSize 每页数据量
     * @param param 参数
     * @return 返回结果
     */
    IPage<BillInfo> selectBillInfoPage(int pageNum, int pageSize, String param);

    /**
     * 新增一条账单信息
     * @param billInfo 账单信息
     * @return 返回结果
     */
    int addBillInfo(BillInfo billInfo);

    /**
     * 修改一条账单信息
     * @param billInfo 账单信息
     * @return 返回结果
     */
    int editBillInfo(BillInfo billInfo);

    /**
     * 根据id查询账单信息
     * @param id id
     * @return 返回结果
     */
    BillInfo queryBillInfoById(Integer id);

    /**
     * 根据id删除账单信息
     * @param id id
     * @return 返回结果
     */
    int delBillInfoById(Integer id);

}
