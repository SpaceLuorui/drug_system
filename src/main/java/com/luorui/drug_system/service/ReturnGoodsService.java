package com.luorui.drug_system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.luorui.drug_system.entity.ReturnGoods;

/**
 * @author 罗锐
 * @date 2023/5/6
 */
public interface ReturnGoodsService extends IService<ReturnGoods> {
    /**
     * 分页查询收到退货数据
     * @param pageNum 第几页
     * @param pageSize 每页多少条数据
     * @param param 查询参数-收到退货名称
     * @return 返回结果
     */
    IPage<ReturnGoods> queryReturnGoodsPage(int pageNum, int pageSize, String param);

    /**
     * 新增一条收到退货信息
     * @param returnGoods
     */
    int addReturnGoods(ReturnGoods returnGoods);

    /**
     * 修改一条收到退货信息
     * @param returnGoods
     */
    int editReturnGoods(ReturnGoods returnGoods);

    /**
     * 根据主键id查询一个收到退货对象
     * @param id id
     * @return
     */
    ReturnGoods queryReturnGoodsById(Integer id);

    /**
     * 根据主键id删除一个收到退货对象
     * @param id id
     * @return
     */
    public int delReturnGoodsById(Integer id);

}
